package ood.account;

import ood.address.Address;
import ood.payment.Card;
import ood.payment.EWallets;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Account account;
    private Address address;
    private List<Card> Cards;
    private List<EWallets> eWallets;

}
