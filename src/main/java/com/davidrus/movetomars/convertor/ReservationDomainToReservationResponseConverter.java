package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.domain.ReservationDomain;
import com.davidrus.movetomars.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

/**
 * This class will convert a ReservationDomain to a ReservationResponse class
 * Than we will use the ReservationResponse in the POST method on our Rest Controller
 * Class used to keep the logic out of the controller
 */
public class ReservationDomainToReservationResponseConverter implements Converter<ReservationDomain, ReservationResponse> {
    /**
     * Convert the source object of type {ReservationDomain} to target type {ReservationResponse}.
     *
     * @param source the source object to convert, which must be an instance of {ReservationDomain}
     * @return the converted object, which must be an instance of {ReservationResponse}
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public ReservationResponse convert(ReservationDomain source) {

        ReservationResponse reservationResponse = new ReservationResponse();

        if (null != source.getModuleDomain().getId())
            reservationResponse.setId(source.getModuleDomain().getId());

        reservationResponse.setCheckin(source.getCheckin());
        reservationResponse.setCheckout(source.getCheckout());

        return reservationResponse;
    }
}
