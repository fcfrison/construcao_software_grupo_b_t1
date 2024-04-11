package com.grupoB.account.domain.entities;

public class Account {
        private Integer id;
        private Boolean receiveEmails;
        private Boolean receivePush;
        private Boolean allowDataShare;
        private Boolean profileVisibility;
        private Boolean transactionHistoryVisible;
        private Boolean  wantToReceiveMarketing;

    public Account(Boolean receiveEmails, Boolean receivePush, Boolean allowDataShare, Boolean profileVisibility,
                   Boolean transactionHistoryVisible, Boolean wantToReceiveMarketing, Integer id) {
        this.id = id;
        this.receiveEmails = receiveEmails;
        this.receivePush = receivePush;
        this.allowDataShare = allowDataShare;
        this.profileVisibility = profileVisibility;
        this.transactionHistoryVisible = transactionHistoryVisible;
        this.wantToReceiveMarketing = wantToReceiveMarketing;
    }

    public Boolean getReceiveEmails() {
        return receiveEmails;
    }

    public void setReceiveEmails(Boolean receiveEmails) {
        this.receiveEmails = receiveEmails;
    }

    public Boolean getReceivePush() {
        return receivePush;
    }

    public void setReceivePush(Boolean receivePush) {
        this.receivePush = receivePush;
    }

    public Boolean getAllowDataShare() {
        return allowDataShare;
    }

    public void setAllowDataShare(Boolean allowDataShare) {
        this.allowDataShare = allowDataShare;
    }

    public Boolean getProfileVisibility() {
        return profileVisibility;
    }

    public void setProfileVisibility(Boolean profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    public Boolean getTransactionHistoryVisible() {
        return transactionHistoryVisible;
    }

    public void setTransactionHistoryVisible(Boolean transactionHistoryVisible) {
        this.transactionHistoryVisible = transactionHistoryVisible;
    }

    public Boolean getWantToReceiveMarketing() {
        return wantToReceiveMarketing;
    }

    public void setWantToReceiveMarketing(Boolean wantToReceiveMarketing) {
        this.wantToReceiveMarketing = wantToReceiveMarketing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
