package org.example.Entities;



public class BookingDates {
    private String checkin;
    private String checkout;

    public BookingDates(String checkIn, String checkOut ){
        this.checkin = checkIn;
        this.checkout = checkOut;
    }

    public String getCheckIn() {
        return checkin;
    }

    public String getCheckOut() {
        return checkout;
    }

    public void setCheckIn(String checkIn) {
        this.checkin = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkout = checkOut;
    }
}
