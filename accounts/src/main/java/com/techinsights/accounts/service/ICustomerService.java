package com.techinsights.accounts.service;

import com.techinsights.accounts.dto.CustomerDetailsDTO;

public interface ICustomerService {
    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @param correlationID - UUID of the correlation
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDTO fetchCustomerDetails(String correlationID, String mobileNumber);
}
