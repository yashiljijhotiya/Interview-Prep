package ood.payment;

import ood.enums.BookingStatus;

import java.util.Date;

public class Booking {
    private String bookingNumber;
    private int noOfBookings;
    private Date createdOn;
    private BookingStatus status;
    private Payment payment;
}
