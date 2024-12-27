package com.techinsights.accounts.service;

import com.techinsights.accounts.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customer);

    CustomerDTO fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDTO customerDto);

    boolean deleteAccount(String mobileNumber);
}
