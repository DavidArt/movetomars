package com.davidrus.movetomars.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * The domain representing a module to reserve
 * This domain will be used to populate the database
 */
@Entity
@Table(name = "Module")
public class ModuleDomain {

    /**
     * Id of the Module, used as a primary key in db
     * <p>
     * Will be auto generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The module number which should never be null
     */
    @NotNull
    private Integer moduleNumber;

    /**
     * The price of the module to book
     */
    @NotNull
    private Integer price;

    /**
     * Default, a OneToMany annotation is Lazy because we can have
     * a lot of ReservationDomain entities
     * <p>
     * We want it to be Eager to have immediate access to that data
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ReservationDomain> reservationDomainList;

    /**
     * Creates a new ModuleDomain instance with default values
     */
    public ModuleDomain() {
    }

    /**
     * Creates a new ModuleDomain instance initializing the:
     *
     * @param moduleNumber The module number
     * @param price        The price of the module
     */
    public ModuleDomain(Integer moduleNumber, Integer price) {
        this.moduleNumber = moduleNumber;
        this.price = price;
    }

    public Integer getModuleNumber() {
        return moduleNumber;
    }

    public void setModuleNumber(Integer moduleNumber) {
        this.moduleNumber = moduleNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ReservationDomain> getReservationDomainList() {
        return reservationDomainList;
    }

    public void setReservationDomainList(List<ReservationDomain> reservationDomainList) {
        this.reservationDomainList = reservationDomainList;
    }

    public void addReservationEntity(ReservationDomain reservationDomain) {
        if (null == reservationDomainList)
            reservationDomainList = new ArrayList<>();

        reservationDomainList.add(reservationDomain);
    }
}
