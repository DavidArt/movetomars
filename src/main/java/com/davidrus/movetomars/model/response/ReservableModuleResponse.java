package com.davidrus.movetomars.model.response;

import com.davidrus.movetomars.model.Link;

/**
 * @author david
 * <p>
 * Reservation response for the ReservationResource class
 * We send a instance of this class as a response in
 * the REST methods from our Rest API class
 */
public class ReservableModuleResponse {

    /**
     * Id of the ReservableModuleResponse
     */
    private Long id;

    /**
     * The number of the module to reserve
     */
    private Integer moduleNumber;

    /**
     * The price to pay for reserving the Mars module
     */
    private Integer price;

    /**
     * A self reference link to the Module to reserve
     */
    private Link link;

    /**
     * Creates a new ReservableModuleResponse instance
     */
    public ReservableModuleResponse() {
        super();
    }

    /**
     * Creates a new ReservableModuleResponse instance and initializes
     * the fields with the passed values to the constructor
     *
     * @param moduleNumber
     * @param price
     */
    public ReservableModuleResponse(Integer moduleNumber, Integer price) {
        this.moduleNumber = moduleNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
