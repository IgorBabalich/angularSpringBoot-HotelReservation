package hotel.hotelreservation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkin;

	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate checkout;

	@ManyToOne
	private RoomEntity roomEntity;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(LocalDate checkin, LocalDate checkout) {
		super();
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

	public RoomEntity getRoomEntity() {
		return roomEntity;
	}

	public void setRoomEntity(RoomEntity roomEntity) {
		this.roomEntity = roomEntity;
	}

	@Override
	public String toString() {
		return "ReservationEntity [id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + ", roomEntity="
				+ roomEntity + "]";
	}

}
