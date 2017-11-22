package hotel.hotelreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import hotel.hotelreservation.entity.RoomEntity;
import hotel.hotelreservation.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner  {

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("==> Bootstrapping data ...");
		
		roomRepository.save(  new RoomEntity(11, "211") );
		roomRepository.save(  new RoomEntity(12, "212") );
		roomRepository.save(  new RoomEntity(13, "213") );
		
		Iterable<RoomEntity> itr = roomRepository.findAll();
		for (RoomEntity room : itr) {
			System.out.println( "==>" + room );
		}

		RoomEntity room = roomRepository.findByRoomNumber(11);
		System.out.println(">>>DB Init>found room:"+room);
	
	}

}
