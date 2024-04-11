package com.grupoB.account.domain.services;

import com.grupoB.account.controllers.account.AccountDTO;
import com.grupoB.account.domain.entities.Account;
import com.grupoB.account.domain.repository.IRepoAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private IRepoAccount repoAccount;
    @Autowired
    public AccountService(IRepoAccount repoAccount){
        this.repoAccount = repoAccount;
    }
    public AccountDTO getAccount(Integer id){
        Account account = repoAccount.getAccountById(id);
        return account==null?
                                null:
                                new AccountDTO(account.getReceiveEmails(),account.getReceivePush(),
                                        account.getAllowDataShare(), account.getProfileVisibility(),
                                        account.getTransactionHistoryVisible(),account.getWantToReceiveMarketing());
    }
    public AccountDTO setAccount(Integer id, AccountDTO accountDTO){
        Boolean hasAlreadyAccount = repoAccount.getAccountById(id)!=null;
        if(hasAlreadyAccount){
            return null;
        }
        Account account = repoAccount.setPreferences(accountDTO.receiveEmails(),accountDTO.receivePush(),
                                                         accountDTO.allowDataShare(),accountDTO.profileVisibility(),
                                                         accountDTO.transactionHistoryVisible(),
                                                         accountDTO.wantToReceiveMarketing(), id);
        return new AccountDTO(account.getReceiveEmails(),account.getReceivePush(),
                              account.getAllowDataShare(), account.getProfileVisibility(),
                              account.getTransactionHistoryVisible(),account.getWantToReceiveMarketing());
    }

    public AccountDTO updatePreferences(Integer id, AccountDTO accountDTO){
        Account account = repoAccount.updatePreferences(accountDTO.receiveEmails(),accountDTO.receivePush(),
                                                        accountDTO.allowDataShare(),accountDTO.profileVisibility(),
                                                        accountDTO.transactionHistoryVisible(),
                                                        accountDTO.wantToReceiveMarketing(), id);
        return account==null?
                null:
                new AccountDTO(account.getReceiveEmails(),account.getReceivePush(),
                        account.getAllowDataShare(), account.getProfileVisibility(),
                        account.getTransactionHistoryVisible(),account.getWantToReceiveMarketing());
    }
}
