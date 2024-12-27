package com.techinsights.accounts.mapper;

import com.techinsights.accounts.dto.CustomerDTO;
import com.techinsights.accounts.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDto(CustomerEntity customer, CustomerDTO customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerEntity mapToCustomer(CustomerDTO customerDto, CustomerEntity customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}
