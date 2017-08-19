package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ReservationDomain;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationDomain, Long> {

}
