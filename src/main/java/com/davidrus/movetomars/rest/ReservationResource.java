package com.davidrus.movetomars.rest;

import com.davidrus.movetomars.model.response.ReservationResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * A RestController for reservation
 *
 * A RestController annotation combines a Controller
 * and a RequestBody annotation
 * The Controller annotation is a specialization of
 * the Component annotation that marks the ReservationResource
 * class for auto detection through classpath scanning,
 * meaning it will be auto-wired and added to the
 * Spring Application Context
 */
@RestController
@RequestMapping(ResourceConstants.MODULE_RESERVATION_V1)
public class ReservationResource {

    /**
     * The Rest API for a GET request
     *
     * @param checkin date for checkin to Mars colony
     * @param checkout date for checkout from Mars colony
     * @return a ResponseEntity containing a ReservationResponse
     */
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> getAvailableModules(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout) {

        return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
    }
}