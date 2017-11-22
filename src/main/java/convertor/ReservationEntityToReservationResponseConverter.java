package convertor;

import org.springframework.core.convert.converter.Converter;

import hotel.hotelreservation.entity.ReservationEntity;
import hotel.hotelreservation.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservationEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());
		reservationResponse.setId(source.getId());
		
		return reservationResponse;
	}

}
