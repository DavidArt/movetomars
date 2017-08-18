package com.davidrus.movetomars;

import com.davidrus.movetomars.entity.ModuleEntity;
import com.davidrus.movetomars.repository.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner{

    @Autowired
    ModuleRepository moduleRepository;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrapping data: ");

        moduleRepository.save(new ModuleEntity(405, 200));
        moduleRepository.save(new ModuleEntity(407, 220));
        moduleRepository.save(new ModuleEntity(408, 250));

        Iterable<ModuleEntity> itr = moduleRepository.findAll();

        System.out.println("Printing out data: ");
        for (ModuleEntity module: itr) {
            System.out.println(module.getId() + " " + module.getModuleNumber());
        }
    }

}
