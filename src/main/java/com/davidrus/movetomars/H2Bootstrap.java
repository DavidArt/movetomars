package com.davidrus.movetomars;

import com.davidrus.movetomars.domain.ModuleDomain;
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

        moduleRepository.save(new ModuleDomain(404, 210));
        moduleRepository.save(new ModuleDomain(405, 235));
        moduleRepository.save(new ModuleDomain(406, 275));

        Iterable<ModuleDomain> itr = moduleRepository.findAll();

        System.out.println("Printing out data: ");
        for (ModuleDomain module: itr) {
            System.out.println(module.getId() + " " + module.getModuleNumber());
        }
    }

}
