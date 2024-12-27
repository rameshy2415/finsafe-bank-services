package com.techinsights.accounts.mapper;

import com.techinsights.accounts.dto.AccountDTO;
import com.techinsights.accounts.entity.AccountEntity;

public class AccountsMapper {
    public static AccountDTO mapToAccountsDto(AccountEntity accounts, AccountDTO accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static AccountEntity mapToAccounts(AccountDTO accountsDto, AccountEntity accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

}
