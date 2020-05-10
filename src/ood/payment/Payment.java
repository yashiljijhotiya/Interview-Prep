package ood.payment;

import ood.enums.PaymentStatus;

import java.util.Date;

public class Payment {
    private double amount;
    private Date createdOn;
    private int transactionId;
    private PaymentStatus status;
}
