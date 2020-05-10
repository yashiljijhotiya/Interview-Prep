package ood.notification;

import ood.account.Account;

import java.util.Date;

public class Notification {
    private int id;
    private Date createdOn;
    private String message;

    public boolean sendNotification(Account account){
        return true;
    }
}
