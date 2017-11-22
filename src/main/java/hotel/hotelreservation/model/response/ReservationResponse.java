package hotel.hotelreservation.model.response;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponse {

	private Long id;
	//@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkin;
	//@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkout;

	public ReservationResponse() {
		super();
	}

	public ReservationResponse(Long id, LocalDate checkin, LocalDate checkout) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

}
