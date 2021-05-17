import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CheckAvailability {

	
	public void CheckAvailbility() throws ParseException, IOException {
		
		Menu MenuObject = new Menu();
		
		Scanner s = new Scanner(System.in);

		System.out.println("Please Input the desired Arrival Date, format yyyy-mm-dd:");
		String startDate = s.next();

		System.out.println("Please Input the desired Departure date, format yyyy-mm-dd:");
		String endDate = s.next();
		
		
		
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		
		File Bookings = new File("Bookings.csv");
		
		Scanner BookingScanner = new Scanner(Bookings);
		
		LocalDate date = start;
		
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> bookingApartments = new ArrayList<String>();
		
		while(date.isBefore(end)) {
			
			String sDate = date.toString();
			
			dates.add(sDate);
			
			date = date.plusDays(1);
			
		}
		dates.add(endDate);
		
		
		while(BookingScanner.hasNextLine()) {
			
			String data = BookingScanner.nextLine();
			String[] values = data.split(",");
			
			if(dates.contains(values[6])) {
				bookingApartments.add(values[4]);
			}
			
		}
		
		System.out.println("\nApartments Availability:\n");
		
		if(bookingApartments.contains("Andreas")) {
			System.out.println("Andreas | 6 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Andreas | 6 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Arbory")) {
			System.out.println("Arbory | 2 people | Disabled: True | = UNAVAILABLE");
		}
		else {
			System.out.println("Arbory | 2 people | Disabled: True | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Ballaugh")) {
			System.out.println("Ballaugh | 4 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Ballaugh | 4 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Braddan")) {
			System.out.println("Braddan | 3 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Braddan | 3 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Bride")) {
			System.out.println("Bride | 2 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Bride | 2 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Lezayre")) {
			System.out.println("Lezayre | 4 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Lezayre | 4 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Marown")) {
			System.out.println("Marown | 6 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Marown | 6 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Maughold")) {
			System.out.println("Maughold | 4 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Maughold | 4 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Melew")) {
			System.out.println("Melew | 6 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Melew | 6 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Onchan")) {
			System.out.println("Onchan | 3 people | Disabled: True | = UNAVAILABLE");
		}
		else {
			System.out.println("Onchan | 3 people | Disabled: True | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Patrick")) {
			System.out.println("Patrick | 4 people | Disabled: False | = UNAVAILABLE");
		}
		else {
			System.out.println("Patrick | 4 people | Disabled: False | = AVAILABLE");
		}
		
		if(bookingApartments.contains("Rushen")) {
			System.out.println("Rushen | 4 people | Disabled: True | = UNAVAILABLE");
		}
		else {
			System.out.println("Rushen | 4 people | Disabled: True | = AVAILABLE");
		}
		
		System.out.println("\nReturning you to the Main Menu.");
		MenuObject.mainMenu();
		return;
	}
	
	
}
