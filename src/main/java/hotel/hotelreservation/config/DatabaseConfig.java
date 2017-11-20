package hotel.hotelreservation.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("hotelreservation")
@EnableTransactionManagement
public class DatabaseConfig {

}
