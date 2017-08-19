package com.davidrus.movetomars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Reservation")
public class ReservationDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate checkin;

    @NotNull
    private LocalDate checkout;

    @ManyToOne
    private ModuleDomain moduleDomain;

    public ReservationDomain() {
    }

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
