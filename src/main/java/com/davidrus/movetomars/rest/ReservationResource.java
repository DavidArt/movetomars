package com.davidrus.movetomars.rest;

import com.davidrus.movetomars.convertor.ModuleEntityToReservableModuleResponseConverter;
import com.davidrus.movetomars.domain.ModuleDomain;
import com.davidrus.movetomars.domain.ReservationDomain;
import com.davidrus.movetomars.model.request.ReservationRequest;
import com.davidrus.movetomars.model.response.ReservableModuleResponse;
import com.davidrus.movetomars.model.response.ReservationResponse;
import com.davidrus.movetomars.repository.ModuleRepository;
import com.davidrus.movetomars.repository.PageableModuleRepository;
import com.davidrus.movetomars.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author david
 *
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
@CrossOrigin
public class ReservationResource {

    @Autowired
    PageableModuleRepository pageableModuleRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ConversionService conversionService;

    /**
     * The Rest Api for the CREATE request
     *
     * @param reservationRequest the request for creating a new reservation
     * @return a ResponseEntity containing a ReservableModuleResponse
     * with 201 (CREATED) status
     */
    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
            @RequestBody ReservationRequest reservationRequest) {

        ReservationDomain reservationDomain = conversionService.convert(reservationRequest, ReservationDomain.class);
        reservationRepository.save(reservationDomain);

        ModuleDomain moduleDomain = moduleRepository.findById(reservationRequest.getModuleId());
        moduleDomain.addReservationEntity(reservationDomain);
        moduleRepository.save(moduleDomain);
        reservationDomain.setModuleDomain(moduleDomain);

        ReservationResponse reservationResponse = conversionService.convert(reservationDomain, ReservationResponse.class);

        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }

    /**
     * The Rest API for a GET request
     *
     * @param checkin date for checkin to Mars colony
     * @param checkout date for checkout from Mars colony
     * @return a ResponseEntity containing a ReservableModuleResponse
     * with 200 (OK) status
     */
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableModuleResponse> getAvailableModules(
            @RequestParam(value = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(value = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout, Pageable pageable) {

        Page<ModuleDomain> moduleEntityList = pageableModuleRepository.findAll(pageable);

        return moduleEntityList.map(new ModuleEntityToReservableModuleResponseConverter());
    }

    @RequestMapping(path = "/{moduleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ModuleDomain> getModuleById(@PathVariable Long moduleId) {
        ModuleDomain moduleDomain = moduleRepository.findById(moduleId);

        return new ResponseEntity<>(moduleDomain, HttpStatus.OK);
    }

    /**
     * The Rest Api for the PUT request
     *
     * @param reservationRequest the request for updating an existing reservation
     * @return a ResponseEntity containing a ReservableModuleResponse
     * with 200 (OK) status
     */
    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableModuleResponse> updateReservation(
            @RequestBody ReservationRequest reservationRequest) {

        return new ResponseEntity<>(new ReservableModuleResponse(), HttpStatus.OK);
    }

    /**
     * The Rest Api for the DELETE request
     *
     * @param reservationId the id of the user that made the reservation
     * @return
     */
    @RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
