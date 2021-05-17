import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplaySchedule {

	
	public void Schedule() throws ParseException, IOException {
		
		Menu MenuObject = new Menu();
		
		LocalDate date = LocalDate.now();
		
		String sDate = date.toString();
		
		ArrayList<String> dates = new ArrayList<String>();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		date = date.plusDays(1);
		sDate = date.toString();
		dates.add(sDate);
		
		File Arrivals = new File("Arrivals.csv");
		File Departures = new File("Departures.csv");
		
		Scanner ArrivalScanner = new Scanner(Arrivals);
		Scanner DeparturesScanner = new Scanner(Departures);
		
		
		System.out.println("Upcoming Arrivals in the next 7 days:\n");
		
		
		while(ArrivalScanner.hasNextLine()) {
			
			String data = ArrivalScanner.nextLine();
			String[] values = data.split(",");
			
			if(dates.contains(values[6])) {
				//System.out.println("\n");
				System.out.println("Booking ID: " + values[0]);
				System.out.println("Name: " + values[1]);
				System.out.println("Email: " + values[2]);
				System.out.println("Phone No: " + values[3]);
				System.out.println("Apartment: " + values[4]);
				System.out.println("Party Size: " + values[5]);
				System.out.println("Date: " + values[6]);
				System.out.println("\n");
			}
			
			
		}
		ArrivalScanner.close();
		
		System.out.println("Upcoming Departures in the next 7 days:\n");
		
		
		while(DeparturesScanner.hasNextLine()) {
			
			String data = DeparturesScanner.nextLine();
			String[] values = data.split(",");
			
			if(dates.contains(values[6])) {
				//System.out.println("\n");
				System.out.println("Booking ID: " + values[0]);
				System.out.println("Name: " + values[1]);
				System.out.println("Email: " + values[2]);
				System.out.println("Phone No: " + values[3]);
				System.out.println("Apartment: " + values[4]);
				System.out.println("Party Size: " + values[5]);
				System.out.println("Date: " + values[6]);
				System.out.println("\n");
			}
			
			
		}
		DeparturesScanner.close();
		
		System.out.println("Returning you to the Main Menu.");
		MenuObject.mainMenu();
		
	}
	
	
}
