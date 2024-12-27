package com.techinsights.accounts.service.impl;

import com.techinsights.accounts.constant.AccountsConstants;
import com.techinsights.accounts.dto.AccountDTO;
import com.techinsights.accounts.dto.CustomerDTO;
import com.techinsights.accounts.entity.AccountEntity;
import com.techinsights.accounts.entity.CustomerEntity;
import com.techinsights.accounts.exception.CustomerAlreadyExistsException;
import com.techinsights.accounts.exception.ResourceNotFoundException;
import com.techinsights.accounts.mapper.AccountsMapper;
import com.techinsights.accounts.mapper.CustomerMapper;
import com.techinsights.accounts.repository.AccountRepository;
import com.techinsights.accounts.repository.CustomerRepositiry;
import com.techinsights.accounts.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;

    private final CustomerRepositiry customerRepositiry;




    @Override
    public void createAccount(CustomerDTO customerDTO) {


        Optional<CustomerEntity> byMobileNumber = customerRepositiry.findByMobileNumber(customerDTO.getMobileNumber());
        if(byMobileNumber.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with given mobile number: "+ customerDTO.getMobileNumber());
        }
        CustomerEntity savedCustomer = createCustomer(customerDTO);
        accountRepository.save(createNewAccount(savedCustomer));

    }


    private CustomerEntity createCustomer(CustomerDTO customerDTO){
        CustomerEntity customerEntity =  CustomerMapper.mapToCustomer(customerDTO, new CustomerEntity());
        return customerRepositiry.save(customerEntity);
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private AccountEntity createNewAccount(CustomerEntity customer) {
        AccountEntity newAccount = new AccountEntity();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }


    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        CustomerEntity customer = customerRepositiry.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        AccountEntity accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDTO customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountDTO()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDto) {
        boolean isUpdated = false;
        AccountDTO accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            AccountEntity accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            CustomerEntity customer = customerRepositiry.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepositiry.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        CustomerEntity customer = customerRepositiry.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepositiry.deleteById(customer.getCustomerId());
        return true;
    }
}
