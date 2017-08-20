package com.davidrus.movetomars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author david
 *
 * Main point for starting the application
 *
 * EnableAutoConfiguration -> Automated bean configuration
 * ComponentScan -> Automated scan for configuration classes
 * to wire up in the Spring Application Context
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MovetomarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovetomarsApplication.class, args);
	}
}
