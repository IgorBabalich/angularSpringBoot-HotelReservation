package hotel.hotelreservation.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import convertor.RoomEntitiyToReservableResponseConverter;
import hotel.hotelreservation.entity.ReservationEntity;
import hotel.hotelreservation.entity.RoomEntity;
import hotel.hotelreservation.model.request.ReservationRequest;
import hotel.hotelreservation.model.response.ReservableRoomResponse;
import hotel.hotelreservation.model.response.ReservationResponse;
import hotel.hotelreservation.repository.PageableRoomRepository;
import hotel.hotelreservation.repository.ReservationRepository;
import hotel.hotelreservation.repository.RoomRepository;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@Autowired
	PageableRoomRepository pageableRoomRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ConversionService conversionService;
	
	@RequestMapping(path="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//public ResponseEntity<ReservationResponse> getAvailableRooms( 
	public Page<ReservableRoomResponse> getAvailableRooms( 
			@RequestParam(value="checkin") 
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
			LocalDate checkin, 
			@RequestParam(value="checkout") 
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
			LocalDate checkout,
			Pageable pageable){
		
		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		
		//return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
		return roomEntityList.map( new RoomEntitiyToReservableResponseConverter());
	}
	
	@RequestMapping(path="/{roomId}",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(
			@PathVariable
			Long roomId) {
		
		RoomEntity roomEntity = roomRepository.findById(roomId);
		
		return new ResponseEntity<>(roomEntity, HttpStatus.OK);
	}

	@RequestMapping(path="", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<ReservationResponse> createReservation( 
			@RequestBody
			ReservationRequest reservationRequest ) {
		
		System.out.println("==>createReservation( reservationRequest:"+reservationRequest);
		
		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		System.out.println("==>reservationEnity after convert:"+reservationEntity);
		
		reservationRepository.save(reservationEntity);
		System.out.println("==>reservationEnity after save:"+reservationEntity);
				
		RoomEntity roomEntity = roomRepository.findByRoomNumber(reservationRequest.getRoomNumber());
		System.out.println("==>roomEntity:"+roomEntity);
		
		roomEntity.addReservationEntity(reservationEntity);
		System.out.println("==>roomEntity:"+roomEntity);
		roomRepository.save(roomEntity);
		System.out.println("==>roomEntity after save:"+roomEntity);
		
		reservationEntity.setRoomEntity(roomEntity);
		//System.out.println("==>reservationEnity after setRoomEntity:"+reservationEntity);
		
		ReservationResponse reservationResponse = conversionService.convert(reservationEntity, ReservationResponse.class);
		
				
		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@RequestMapping(path="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<ReservableRoomResponse> updateReservation( 
			@RequestBody
			ReservationRequest reservationRequest ) {
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/{reservationId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId ) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}





