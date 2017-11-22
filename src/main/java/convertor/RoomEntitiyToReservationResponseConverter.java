package convertor;


import org.springframework.core.convert.converter.Converter;

import hotel.hotelreservation.entity.RoomEntity;
import hotel.hotelreservation.model.Links;
import hotel.hotelreservation.model.Self;
import hotel.hotelreservation.model.response.ReservationResponse;
import hotel.hotelreservation.rest.ResourceConstants;

public class RoomEntitiyToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(RoomEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setRoomNumber( source.getRoomNumber() );
		reservationResponse.setPrice(  Integer.valueOf(source.getPrice())  );
		
		Links links = new Links();
		Self self = new Self();
		self.setRef( ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		reservationResponse.setLinks(links);
				
		return reservationResponse;
	}



}