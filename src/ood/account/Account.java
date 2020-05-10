package ood.account;

import ood.enums.AccountStatus;

public class Account {
    private String userName;
    private String password;
    private AccountStatus accountStatus;

    public boolean resetPassword(){
        return true;
    }
}
