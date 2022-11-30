package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Reservation;
import models.exception.DomainException;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Reservation> list = new ArrayList<>();

		try {
			System.out.print("Room number:");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			list.add(reservation);
			System.out.print("Reservation " + reservation);

			System.out.print("\nEnter data to update the reservation:\n");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkin, checkout);
			System.out.print("Reservation " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid format!");
		} catch (DomainException e) {
			System.out.println("Error in reservation:" + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}

		sc.close();
	}
}
