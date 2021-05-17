import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CreateBooking {

	//User Input Values
	String startDate = "null";
	String endDate = "null";
	String apartment = "null";
	
	public void AvailabilityCheck() throws ParseException, IOException {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("\nPlease Input the name of the desired apartment:");
		apartment = s.nextLine();

		System.out.println("Please Input the Arrival Date, format yyyy-mm-dd:");
		startDate = s.next();

		System.out.println("Please Input Departure date, format yyyy-mm-dd:");
		endDate = s.next();
		
		

		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		
		File Bookings = new File("Bookings.csv");
		
		Scanner BookingScanner = new Scanner(Bookings);
		
		boolean unavailable = false;
		
		LocalDate date = start;
		
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> bookingDates = new ArrayList<String>();
		
		while(date.isBefore(end)) {
			
			String sDate = date.toString();
			
			dates.add(sDate);
			
			date = date.plusDays(1);
			
		}
		dates.add(endDate);
		
		while(BookingScanner.hasNextLine()) {
			
			String data = BookingScanner.nextLine();
			String[] values = data.split(",");
			
			if(values[4].contains(apartment)) {
				
				bookingDates.add(values[6]);
				
			}
			
		}
		
		
		Iterator<String> datesIterator = dates.iterator();
		while(datesIterator.hasNext()) {
			
			String temp = datesIterator.next();
			
			if(bookingDates.contains(temp)) {
				unavailable = true;
			}
			
		}
		
		
		if (unavailable == true) {
			System.out.println("Sorry, that apartment already has a reservation for the desired stay.");
			System.out.println("Please check availability and try again.");
			AvailabilityCheck();
		}
		else if (unavailable == false) {
			System.out.println("The apartment is available for the desired dates.");
			newBooking();
		}
		
		
	}
	
	
	public void newBooking() throws ParseException, IOException {
		
		Menu MenuObject = new Menu();
		
		Scanner c = new Scanner(System.in);
		
		System.out.println("Please Input the customer's fullname:");
		String customerName = c.nextLine();
		
		System.out.println("Please Input the customer's email address:");
		String customerEmail = c.nextLine();
		
		System.out.println("Please Input the customer's phone number:");
		String customerPhone = c.nextLine();
		
		System.out.println("Please Input the party size:");
		String partySize = c.nextLine();
		
		//c.close();
		
		
		
		
		
		File ID = new File("UniqueBookingNumber.txt");
		Scanner scanID = new Scanner(ID);
		
		String bookingID = scanID.next();
		
		//scanID.close();
		
		int i = Integer.parseInt(bookingID);
		int u = 1;
		int e = i + u;
		
		String updatedID = String.valueOf(e);
		
		FileWriter fw = new FileWriter(ID);
		fw.write(updatedID);
		fw.close();

		
		
	
		
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		File Bookings = new File("Bookings.csv");
		FileWriter bw = new FileWriter(Bookings, true);
		PrintWriter pw = new PrintWriter(bw);
		
		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
		    String reservation = e + "," + customerName + "," + customerEmail + "," + customerPhone + "," + apartment + "," + partySize + "," + date;
		    pw.println(reservation);
		}
		String lastDay = e + "," + customerName + "," + customerEmail + "," + customerPhone + "," + apartment + "," + partySize + "," + end;
		pw.println(lastDay);
		pw.close();
		
		//Adds arrival to arrivals log
		File Arrivals = new File("Arrivals.csv");
		FileWriter afw = new FileWriter(Arrivals, true);
		PrintWriter apw = new PrintWriter(afw);
		String arrival = e + "," + customerName + "," + customerEmail + "," + customerPhone + "," + apartment + "," + partySize + "," + start;
		apw.println(arrival);
		apw.close();
		
		//Adds departure to departures log
		File Departures = new File("Departures.csv");
		FileWriter dfw = new FileWriter(Departures, true);
		PrintWriter dpw = new PrintWriter(dfw);
		String departure = e + "," + customerName + "," + customerEmail + "," + customerPhone + "," + apartment + "," + partySize + "," + end;
		dpw.println(departure);
		dpw.close();
		
		System.out.println("\nYour Booking Details:");
		System.out.println("Booking ID: " + e);
		System.out.println("Name: " + customerName);
		System.out.println("Email: " + customerEmail);
		System.out.println("Phone: " + customerPhone);
		System.out.println("Party Size: " + partySize);
		System.out.println("Apartment: " + apartment);
		System.out.println("Arrival: " + startDate);
		System.out.println("Departure: " + endDate);
		
		System.out.println("\nReturning you to the Main Menu.");
		MenuObject.mainMenu();
		
	}
	
	
}
