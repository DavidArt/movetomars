package com.davidrus.movetomars.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * EnableJpaRepositories enables automated scanning for Jpa repositories
 * <p>
 * EnableTransactionManagement registers the necessary Spring component
 * such as TransactionInterceptor which power the annotation-driven
 * transaction management
 */
@EnableJpaRepositories("com.davidrus.movetomars.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
