package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ModuleDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * A PagingAndSortingRepository is similar to a CRUD repository, excepts
 * it lets you page the results
 * PagingAndSortingRepository provide methods to do pagination and sorting records.
 */
public interface PageableModuleRepository extends PagingAndSortingRepository<ModuleDomain, Long> {

    /**
     * Method that returns a Page object containing a list
     * of ModuleDomains
     * @param id
     * @param page
     * @return a Page object containing ModuleEntities
     */
    Page<ModuleDomain> findById(Long id, Pageable page);

}

