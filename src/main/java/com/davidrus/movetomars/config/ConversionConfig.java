package com.davidrus.movetomars.config;

import com.davidrus.movetomars.convertor.ModuleDomainToReservableModuleResponseConverter;
import com.davidrus.movetomars.convertor.ReservationDomainToReservationResponseConverter;
import com.davidrus.movetomars.convertor.ReservationRequestToReservationDomainConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * ConversionConfig class will register converters,
 * that will allow us to convert requests or response objects
 * from front end, into entities and vice versa
 */
@Configuration
public class ConversionConfig {

    /**
     * Method that will return a HashSet of converter objects
     */
    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new ModuleDomainToReservableModuleResponseConverter());
        converters.add(new ReservationRequestToReservationDomainConverter());
        converters.add(new ReservationDomainToReservationResponseConverter());

        return converters;
    }

    /**
     * ConversionService Factory Bean
     * Used to convert our resources
     *
     * @return a ConversionServiceFactoryBean bean
     */
    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
