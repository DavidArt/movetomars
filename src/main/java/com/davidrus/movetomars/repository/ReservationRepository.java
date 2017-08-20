package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ReservationDomain;
import org.springframework.data.repository.CrudRepository;

/**
 * The ReservationRepository will extend the CRUD Repository
 * Will take in as parameters a ReservationDomain and a Long,
 * representing the Id of the Entity we want to retrieve
 */
public interface ReservationRepository extends CrudRepository<ReservationDomain, Long> {

}
