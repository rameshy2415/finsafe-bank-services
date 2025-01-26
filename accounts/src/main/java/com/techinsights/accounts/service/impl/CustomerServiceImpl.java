package com.techinsights.accounts.service.impl;

import com.techinsights.accounts.client.CardsFeignClient;
import com.techinsights.accounts.client.LoansFeignClient;
import com.techinsights.accounts.dto.AccountDTO;
import com.techinsights.accounts.dto.CardDTO;
import com.techinsights.accounts.dto.CustomerDetailsDTO;
import com.techinsights.accounts.dto.LoanDTO;
import com.techinsights.accounts.entity.AccountEntity;
import com.techinsights.accounts.entity.CustomerEntity;
import com.techinsights.accounts.exception.ResourceNotFoundException;
import com.techinsights.accounts.mapper.AccountsMapper;
import com.techinsights.accounts.mapper.CustomerMapper;
import com.techinsights.accounts.repository.AccountRepository;
import com.techinsights.accounts.repository.CustomerRepository;
import com.techinsights.accounts.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationID) {
        CustomerEntity customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        AccountEntity accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDTO customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDTO());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountDTO()));

        ResponseEntity<LoanDTO> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationID, mobileNumber);
        if(null != loansDtoResponseEntity) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardDTO> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationID, mobileNumber);
        if(null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;

    }
}
