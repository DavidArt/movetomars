package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ModuleDomain;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface ModuleRepository extends CrudRepository<ModuleDomain, Long> {

    ModuleDomain findById(Long id);
}
