package com.davidrus.movetomars.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david
 *
 * Configuration class for deserialization of Jsona into
 * Pojos, and serialization of Pojos into Jsons
 */
@Configuration
public class ApiConfig {

    /**
     * ObjectMapper defines how Json strings from the request body
     * are deserialized in POJO (Plain Old Java Object).
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    /**
     * ObjectWriter defines how we serialize the POJO into
     * a Json string in the response body.
     *
     * @param objectMapper the param to take
     * @return a ObjectWriter object
     *
     * We use the ObjectMapper to create a default PrettyPrinter
     * which will output a Json in a human readable format
     */
    @Bean
    public ObjectWriter objectWriter(ObjectMapper objectMapper) {
        return objectMapper.writerWithDefaultPrettyPrinter();
    }
}
