package com.davidrus.movetomars.model.response;

import java.time.LocalDate;

/**
 * ReservationResponse class is used in our REST API
 * methods to return a response object for our front-end,
 * object that will be serialized into a Json using the
 * ObjectWriter bean
 */
public class ReservationResponse {

    /**
     * Id of the reservation response
     */
    private Long id;

    /**
     * The checkin date
     */
    private LocalDate checkin;

    /**
     * The Checkout date
     */
    private LocalDate checkout;

    /**
     * Creates a default ReservationResponse instance
     */
    public ReservationResponse() {
    }

    /**
     * Creates a ReservationResponse instance initializing the fields:
     *
     * @param id       Id of the reservation response
     * @param checkin  The checkin date
     * @param checkout The Checkout date
     */
    public ReservationResponse(Long id, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }
}
