package org.example.Entities;

public class Booking {

    private String firstname;
    private String lastname;
    private float totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking(String firstName, String lastName, float totalPrice, boolean depositPaid, BookingDates bookingDates, String additionalNeeds){
        this.firstname = firstName;
        this.lastname = lastName;
        this.totalprice = totalPrice;
        this.depositpaid = depositPaid;
        this.bookingdates = bookingDates;
        this.additionalneeds = additionalNeeds;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public float getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalprice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositpaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

    public String getAdditionalNeeds() {
        return additionalneeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalneeds = additionalNeeds;
    }
}
