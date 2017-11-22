package hotel.hotelreservation.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {

	private Long id;

	private Integer  roomNumber;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkout;

	public ReservationRequest() {
		super();
	}

	public ReservationRequest(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
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

	@Override
	public String toString() {
		return "ReservationRequest [id=" + id + ", roomNumber=" + roomNumber + ", checkin=" + checkin + ", checkout=" + checkout
				+ "]";
	}

	
}
