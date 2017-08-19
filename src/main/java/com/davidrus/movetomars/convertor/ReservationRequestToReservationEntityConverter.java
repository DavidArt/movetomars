package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.domain.ReservationDomain;
import com.davidrus.movetomars.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationDomain> {

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
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