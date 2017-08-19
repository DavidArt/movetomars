package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.domain.ModuleDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * A PagingAndSortingRepository is similar to a CRUD repository, excepts
 * it lets you page the results
 */
public interface PageableModuleRepository extends PagingAndSortingRepository<ModuleDomain, Long> {

    /**
     * Method that returns a Page object containing a list
     * of ModuleEntities
     * @param id
     * @param page
     * @return a Page object containing ModuleEntities
     */
    Page<ModuleDomain> findById(Long id, Pageable page);

}

