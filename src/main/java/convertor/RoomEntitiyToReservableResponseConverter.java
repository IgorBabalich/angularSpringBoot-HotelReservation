package convertor;


import org.springframework.core.convert.converter.Converter;

import hotel.hotelreservation.entity.RoomEntity;
import hotel.hotelreservation.model.Links;
import hotel.hotelreservation.model.Self;
import hotel.hotelreservation.model.response.ReservableRoomResponse;
import hotel.hotelreservation.rest.ResourceConstants;

public class RoomEntitiyToReservableResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {

		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
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
