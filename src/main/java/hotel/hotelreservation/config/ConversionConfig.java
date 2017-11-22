package hotel.hotelreservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Set;
import java.util.HashSet;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import convertor.ReservationEntityToReservationResponseConverter;
import convertor.ReservationRequestToReservationEntityConverter;
import convertor.RoomEntitiyToReservableResponseConverter;

@Configuration
public class ConversionConfig {
	
	private Set<Converter> getConverters() {
		Set<Converter> converters = new HashSet<Converter>();
		converters.add( new RoomEntitiyToReservableResponseConverter() ) ;
		converters.add(new ReservationEntityToReservationResponseConverter());
		converters.add(new ReservationRequestToReservationEntityConverter());
 				
		return converters;
	}

	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean fbean = new ConversionServiceFactoryBean();
		fbean.setConverters(getConverters());
		fbean.afterPropertiesSet();
		
		return fbean.getObject();
	}
}
