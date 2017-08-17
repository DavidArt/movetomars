package com.davidrus.movetomars.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * The entity representing a module to reserve
 * This entity will be used to populate the database
 */
@Entity
@Table(name = "Module")
public class ModuleEntity {

    /**
     * Id of the Module, used as a primary key in db
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ReservationEntity> reservationEntityList;

    /**
     * Creates a new ModuleEntity instance with default values
     */
    public ModuleEntity() {
    }

    /**
     * Creates a new ModuleEntity instance initializing the:
     * @param moduleNumber The module number
     * @param price The price of the module
     */
    public ModuleEntity(Integer moduleNumber, Integer price) {
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

    public List<ReservationEntity> getReservationEntityList() {
        return reservationEntityList;
    }

    public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
        this.reservationEntityList = reservationEntityList;
    }

    public void addReservationEntity(ReservationEntity reservationEntity) {
        if (null == reservationEntityList)
            reservationEntityList = new ArrayList<>();

        reservationEntityList.add(reservationEntity);
    }
}
