package com.davidrus.movetomars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * The domain representing a reservation
 * This domain will be used to populate the database
 */
@Entity
@Table(name = "Reservation")
public class ReservationDomain {

    /**
     * Id of the Reservation, used as a primary key in db
     * <p>
     * Will be auto generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The checkin date
     */
    @NotNull
    private LocalDate checkin;

    /**
     * The checkout date
     */
    @NotNull
    private LocalDate checkout;

    /**
     * Many ReservationDomains can have only one ModuleDomain
     * <p>
     * This relation is used for our data base
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ManyToOne
    private ModuleDomain moduleDomain;

    /**
     * Creates a new ReservationDomain instance with default values
     */
    public ReservationDomain() {
    }

    /**
     * Creates a new ReservationDomain instance initializing the fields:
     *
     * @param checkin  the checkin date
     * @param checkout the checkout date
     */
    public ReservationDomain(LocalDate checkin, LocalDate checkout) {
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

    public ModuleDomain getModuleDomain() {
        return moduleDomain;
    }

    public void setModuleDomain(ModuleDomain moduleDomain) {
        this.moduleDomain = moduleDomain;
    }
}
