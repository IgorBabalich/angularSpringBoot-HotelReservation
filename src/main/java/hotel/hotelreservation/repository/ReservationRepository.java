 package hotel.hotelreservation.repository;

import org.springframework.data.repository.CrudRepository;

import hotel.hotelreservation.entity.ReservationEntity;

public interface ReservationRepository  extends CrudRepository<ReservationEntity, Long>{

}
