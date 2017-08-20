package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.domain.ReservationDomain;
import com.davidrus.movetomars.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

/**
 * This class will convert a ReservationRequest to a ReservationDomain class
 * Than we will use the ReservationResponse in the PUT method on our Rest Controller
 * Class used to keep the logic out of the controller
 */
public class ReservationRequestToReservationDomainConverter implements Converter<ReservationRequest, ReservationDomain> {

    /**
     * Convert the source object of type {ReservationRequest} to target type {ReservationDomain}.
     *
     * @param source the source object to convert, which must be an instance of {ReservationRequest}
     * @return the converted object, which must be an instance of {ReservationDomain}
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public ReservationDomain convert(ReservationRequest source) {

        ReservationDomain reservationDomain = new ReservationDomain();

        if (source.getId() != null) {
            reservationDomain.setId(source.getId());
        }

        reservationDomain.setCheckin(source.getCheckin());
        reservationDomain.setCheckout(source.getCheckout());

        return reservationDomain;
    }
}