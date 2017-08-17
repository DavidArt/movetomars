package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.entity.ModuleEntity;
import com.davidrus.movetomars.model.Link;
import com.davidrus.movetomars.model.Self;
import com.davidrus.movetomars.model.response.ReservationResponse;
import com.davidrus.movetomars.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

/**
 * This class will convert a ModuleEntity to a ReservationResponse class
 * Than we will use the ReservationResponse in the GET method on our Rest Controller
 * Class used to keep the logic out of the controller
 */
public class RoomEntityToReservationResponseConverter implements Converter<ModuleEntity, ReservationResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     * Set the link of the ModuleEntity so that it reflects a reference to itself
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public ReservationResponse convert(ModuleEntity source) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setModuleNumber(source.getModuleNumber());
        reservationResponse.setPrice(source.getPrice());

        Link link = new Link();
        Self self = new Self();
        self.setRef(ResourceConstants.MODULE_RESERVATION_V1 + "/" + source.getId());
        link.setSelf(self);
        reservationResponse.setLink(link);

        return reservationResponse;
    }
}
