package com.davidrus.movetomars.convertor;

import com.davidrus.movetomars.domain.ReservationDomain;
import com.davidrus.movetomars.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationDomain, ReservationResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
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
