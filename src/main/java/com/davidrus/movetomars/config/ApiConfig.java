package com.davidrus.movetomars.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author david
 * <p>
 * Configuration class for deserialization of Jsona into
 * Pojos, and serialization of Pojos into Jsons
 */
@Configuration
public class ApiConfig {

    /**
     * ObjectMapper defines how Json strings from the request body
     * are deserialized in POJO (Plain Old Java Object).
     * Because we register the JavaTimeModule, the objectMapper
     * method will be able to parse ISO formatted dates.
     *
     * @return a ObjectMapper bean
     */
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;
    }

    /**
     * ObjectWriter defines how we serialize the POJO into
     * a Json string in the response body.
     * We use the ObjectMapper to create a default PrettyPrinter
     * which will output a Json in a human readable format
     *
     * @param objectMapper the param to take
     * @return a ObjectWriter bean
     */
    @Bean
    public ObjectWriter objectWriter(ObjectMapper objectMapper) {
        return objectMapper.writerWithDefaultPrettyPrinter();
    }
}
