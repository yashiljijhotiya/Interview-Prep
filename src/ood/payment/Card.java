package ood.payment;

import ood.enums.CardType;

import java.util.Date;

public class Card {
    private String name;
    private long cardNo;
    private Date expiryDate;
    private int cvv;
    private int pin;
    private CardType type;
}
