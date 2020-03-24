package aplicação;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Reserva reserva = null;

		System.out.print("Quarto: ");

		int quarto = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		sc.nextLine();
		String dataCheckin = sc.nextLine();
		System.out.print("Check-out date (dd/MM/yyyy):");
		String dataCheckout = sc.nextLine();

		LocalDate checkin = LocalDate.of(Integer.parseInt(dataCheckin.substring(6, 10)),
				Integer.parseInt(dataCheckin.substring(3, 5)), Integer.parseInt(dataCheckin.substring(0, 2)));

		LocalDate checkout = LocalDate.of(Integer.parseInt(dataCheckout.substring(6, 10)),
				Integer.parseInt(dataCheckout.substring(3, 5)), Integer.parseInt(dataCheckout.substring(0, 2)));

		if (checkout.getDayOfYear() <= checkin.getDayOfYear()) {
			System.out.println("data de checkout invalida!!");
		} else {

			reserva = new Reserva(quarto, LocalDate.of(Integer.parseInt(dataCheckin.substring(6, 10)),
					Integer.parseInt(dataCheckin.substring(3, 5)), Integer.parseInt(dataCheckin.substring(0, 2))),
					LocalDate.of(Integer.parseInt(dataCheckout.substring(6, 10)),
							Integer.parseInt(dataCheckout.substring(3, 5)),
							Integer.parseInt(dataCheckout.substring(0, 2))));
		}
		try {
			System.out.println(reserva.imprimir());
		} catch (java.lang.NullPointerException a) {
			System.out.println("nao foi possivel confirmar reserva");
		}
		System.out.println();

		System.out.println("Reagendar reserva: ");

		System.out.print("Check-in date (dd/MM/yyyy): ");
		dataCheckin = sc.nextLine();
		System.out.print("Check-out date (dd/MM/yyyy):");
		dataCheckout = sc.nextLine();

		checkin = LocalDate.of(Integer.parseInt(dataCheckin.substring(6, 10)),
				Integer.parseInt(dataCheckin.substring(3, 5)), Integer.parseInt(dataCheckin.substring(0, 2)));

		checkout = LocalDate.of(Integer.parseInt(dataCheckout.substring(6, 10)),
				Integer.parseInt(dataCheckout.substring(3, 5)), Integer.parseInt(dataCheckout.substring(0, 2)));

		if (reserva.alterarReserva(checkin, checkout) != null) {
			System.out.println(reserva.alterarReserva(checkin, checkout));
		} else {
			System.out.println(reserva.imprimir());
		}
	}

}
