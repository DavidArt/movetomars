package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.domain.ModuleDomain;
import com.davidrus.movetomars.model.Link;
import com.davidrus.movetomars.model.Self;
import com.davidrus.movetomars.model.response.ReservableModuleResponse;
import com.davidrus.movetomars.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

/**
 * This class will convert a ModuleDomain to a ReservableModuleResponse class
 * Than we will use the ReservableModuleResponse in the GET method on our Rest Controller
 * Class used to keep the logic out of the controller
 */
public class ModuleEntityToReservableModuleResponseConverter implements Converter<ModuleDomain, ReservableModuleResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     * Set the link of the ModuleDomain so that it reflects a reference to itself
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public ReservableModuleResponse convert(ModuleDomain source) {

        ReservableModuleResponse reservableModuleResponse = new ReservableModuleResponse();

        if(null != source.getId())
            reservableModuleResponse.setId(source.getId());

        reservableModuleResponse.setModuleNumber(source.getModuleNumber());
        reservableModuleResponse.setPrice(source.getPrice());

        Link link = new Link();
        Self self = new Self();
        self.setRef(ResourceConstants.MODULE_RESERVATION_V1 + "/" + source.getId());
        link.setSelf(self);

        reservableModuleResponse.setLink(link);

        return reservableModuleResponse;
    }
}
