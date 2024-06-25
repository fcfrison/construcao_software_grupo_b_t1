package com.grupoB.account.domain.repository;


import com.grupoB.account.domain.entities.Account;

public interface IRepoAccount {
    public Account getAccountById(Integer id);
    public Account setPreferences(Boolean receiveEmails, Boolean receivePush, 
                                  Boolean allowDataShare, Boolean profileVisibility,
                                  Boolean transactionHistoryVisible, Boolean wantToReceiveMarketing,
                                  Integer id);
    public Account updatePreferences(Boolean receiveEmails, Boolean receivePush,
                                     Boolean allowDataShare, Boolean profileVisibility,
                                     Boolean transactionHistoryVisible, Boolean wantToReceiveMarketing,
                                     Integer id);
}
