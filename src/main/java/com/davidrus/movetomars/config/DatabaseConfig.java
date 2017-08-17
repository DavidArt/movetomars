package com.davidrus.movetomars.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.davidrus.movetomars.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
