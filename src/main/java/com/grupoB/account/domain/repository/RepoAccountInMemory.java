package com.grupoB.account.domain.repository;


import com.grupoB.account.domain.entities.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Primary
@Repository
public class RepoAccountInMemory implements IRepoAccount {
    private Integer id;
    List<Account> accountList;
    public RepoAccountInMemory(){
        accountList = new LinkedList<Account>();
        id=0;
        for(int i=0;i<40;i++){
            Account account = this.generateRandomAccount();
            accountList.add(account);
        }

    }
    private Account generateRandomAccount(){
        Boolean receiveEmails = (int)(Math.rint(50.0))%2==0 ? true : false;
        Boolean receivePush = (int)(Math.rint(50.0))%2==1 ? true : false;
        Boolean allowDataShare = (int)(Math.rint(50.0))%2==1 ? true : false;
        Boolean profileVisibility = (int)(Math.rint(50.0))%2==0 ? true : false;
        Boolean transactionHistoryVisible = (int)(Math.rint(50.0))%2==0 ? true : false;
        Boolean wantToReceiveMarketing = (int)(Math.rint(50.0))%2==0 ? true : false;
        return new Account(receiveEmails,receivePush,allowDataShare,profileVisibility,
                transactionHistoryVisible,wantToReceiveMarketing, id++);
    }
    @Override
    public Account getAccountById(Integer id) {
        return accountList.stream().filter(account->account.getId().equals(id))
                                   .findFirst().orElse(null);
    }

    @Override
    public Account setPreferences(Boolean receiveEmails, Boolean receivePush, Boolean allowDataShare, Boolean profileVisibility,
                                  Boolean transactionHistoryVisible, Boolean wantToReceiveMarketing, Integer id) {
        Account account = new Account(receiveEmails, receivePush, allowDataShare, profileVisibility,
                                      transactionHistoryVisible, wantToReceiveMarketing, id);
        accountList.add(account);
        return account;
    }

    @Override
    public Account updatePreferences(Boolean receiveEmails, Boolean receivePush, Boolean allowDataShare, Boolean profileVisibility,
                                     Boolean transactionHistoryVisible, Boolean wantToReceiveMarketing, Integer id) {

        Account account = getAccountById(id);
        if(account!=null){
            account.setAllowDataShare(allowDataShare);
            account.setProfileVisibility(profileVisibility);
            account.setReceiveEmails(receiveEmails);
            account.setReceivePush(receivePush);
            account.setTransactionHistoryVisible(transactionHistoryVisible);
            account.setWantToReceiveMarketing(wantToReceiveMarketing);

        }
        return account;
    }
}
