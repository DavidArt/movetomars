package com.davidrus.movetomars.model.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author david
 *
 * From this class, we create a ReservationRequest object wich is
 * passed as a method parameter in the ReservationResource POST
 * method, to create a new reservation
 */
public class ReservationRequest {

    private Long id;

    private Long moduleId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

    /**
     * Default constructor
     * Creates a new ReservationRequest instance
     */
    public ReservationRequest() {
        super();
    }

    /**
     * Creates a new ReservationRequest instance
     * @param moduleId id of the room
     * @param checkin checkin date
     * @param checkout checkout date
     */
    public ReservationRequest(Long id, Long moduleId, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.moduleId = moduleId;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
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
