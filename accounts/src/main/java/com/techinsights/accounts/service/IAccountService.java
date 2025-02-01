package com.techinsights.accounts.service;

import com.techinsights.accounts.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customer);

    CustomerDTO fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDTO customerDto);

    boolean deleteAccount(String mobileNumber);

    /**
     *
     * @param accountNumber - Long
     * @return boolean indicating if the update of communication status is successful or not
     */
    boolean updateCommunicationStatus(Long accountNumber);
}
