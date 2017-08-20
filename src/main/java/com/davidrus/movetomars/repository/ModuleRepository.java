package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ModuleDomain;
import org.springframework.data.repository.CrudRepository;

/**
 * The ModuleRepository will extend the CRUD Repository
 * Will take in as parameters a ModuleDomain and a Long,
 * representing the Id of the Entity we want to retrieve
 */
public interface ModuleRepository extends CrudRepository<ModuleDomain, Long> {

    /**
     * This method will return a module from our database
     * based on the id we provide as a argument in the parameter list
     * <p>
     * Used in the getModuleById method from our Rest API
     *
     * @param id the id of the module to search for
     * @return a ModuleDomain instance by id number
     */
    ModuleDomain findById(Long id);
}
