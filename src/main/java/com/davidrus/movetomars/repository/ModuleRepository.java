package com.davidrus.movetomars.repository;

import com.davidrus.movetomars.entity.ModuleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 */
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long> {

    ModuleEntity findById(Long id);
}
