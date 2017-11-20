package hotel.hotelreservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hotel.hotelreservation.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity,	Long>{
	
	List<RoomEntity> findById(Long id);
		
}
