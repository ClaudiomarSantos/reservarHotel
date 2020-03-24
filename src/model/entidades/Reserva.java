package model.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {

	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	private static DateTimeFormatter formatarComBarras = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
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

	public LocalDate getCheckout() {
		return checkout;
	}

	public int duração() {
		return this.checkout.getDayOfYear() - this.checkin.getDayOfYear();
	}

	public void alterarReserva(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public void formatarData() {
		System.out.println(checkin.format(formatarComBarras));
		System.out.println(checkout.format(formatarComBarras));
	}

	public StringBuilder imprimir() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: ").append("Quarto " + roomNumber + ", ")
				.append("checkin: " + checkin.format(formatarComBarras) + ", ")
				.append("check-out " + checkout.format(formatarComBarras) + ", ").append("duracao " + duração());
		return sb;

	}

}
