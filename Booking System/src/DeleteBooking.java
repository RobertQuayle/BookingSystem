import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBooking {

	public void Delete() throws IOException, ParseException {
		
		Menu MenuObject = new Menu();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please input the Email Address associated with the booking:");
		String email = s.nextLine();
		
		File Bookings = new File("Bookings.csv");
		File Arrivals = new File("Arrivals.csv");
		File Departures = new File("Departures.csv");
		
		Scanner ArrivalScanner = new Scanner(Arrivals);
		Scanner DepartureScanner = new Scanner(Departures);
		Scanner BookingScanner = new Scanner(Bookings);
		
		ArrayList<String> validID = new ArrayList<String>();
		
		boolean emailFound = false;
		
		System.out.println("Bookings related to that email:\n");
		
		while(ArrivalScanner.hasNextLine()) {
			
			String ID = "";
			String Name = "";
			String bEmail = "";
			String PhoneNo = "";
			String Apartment = "";
			String PartySize = "";
			String ArrivalDate = "";
			String DepartureDate = "";
			
			String data = ArrivalScanner.nextLine();
			String[] values = data.split(",");
			
			if(values[2].contentEquals(email)) {
				
				ID = values[0];
				Name = values[1];
				bEmail = values[2];
				PhoneNo = values[3];
				Apartment = values[4];
				PartySize = values[5];
				ArrivalDate = values[6];
				
				while(DepartureScanner.hasNextLine()) {
					
					String departure = DepartureScanner.nextLine();
					String[] aDeparture = departure.split(",");
					
					if(aDeparture[2].contentEquals(email)) {
						
						DepartureDate = aDeparture[6];
						
					}
					
				}
				
				validID.add(ID);
				emailFound = true;
				System.out.println("Booking ID: " + ID);
				System.out.println("Name: " + Name);
				System.out.println("Email: " + bEmail);
				System.out.println("Phone No: " + PhoneNo);
				System.out.println("Apartment: " + Apartment);
				System.out.println("Party Size: " + PartySize);
				System.out.println("Arrival Date: " + ArrivalDate);
				System.out.println("Departure Date: " + DepartureDate);
				System.out.println("\n");
				
			}
			
		}
		
		if(emailFound  == false) {
			System.out.println("Email Not Found, Please Try Again.\n");
			Delete();
			return;
		}
		
		System.out.println("Please input the Booking ID of the reservation you wish to delete:");
		String deletionID = s.nextLine();
		
		if(!validID.contains(deletionID)) {
			System.out.println("\nThat Booking number does not match any reservation linked to the Email Address.");
			System.out.println("Please Try Again.\n");
			Delete();
			return;
		}
		
		boolean confirmDeletion = false;
		
		System.out.println("Please confirm these are the correct details of the booking you wish to delete:\n");
		System.out.println("Email Address: " + email);
		System.out.println("Booking ID: " + deletionID);
		
		while(confirmDeletion == false) {
			
			System.out.println("\nPlease tpye YES or NO:");
			String choice = s.nextLine();
			
			if(choice.contentEquals("YES")) {
				confirmDeletion = true;
			}
			else if(choice.contentEquals("NO")) {
				System.out.println("\nDeletion Cancelled. Returning you to Delete Booking Screen.\n");
				Delete();
				return;
			}
			
		}
		
		Scanner fileArrivalScanner = new Scanner(Arrivals);
		Scanner fileDepartureScanner = new Scanner(Departures);
		
		File temp = new File("Temp.csv");
		FileWriter bw = new FileWriter(temp, true);
		PrintWriter pw = new PrintWriter(bw);
		
		File arrivalTemp = new File("arrivalTemp.csv");
		FileWriter abw = new FileWriter(arrivalTemp, true);
		PrintWriter apw = new PrintWriter(abw);
		
		File departureTemp = new File("departureTemp.csv");
		FileWriter dbw = new FileWriter(departureTemp, true);
		PrintWriter dpw = new PrintWriter(dbw);
		
		while(BookingScanner.hasNextLine()) {
			
			String data = BookingScanner.nextLine();
			String[] values = data.split(",");
			
			if(!values[0].contentEquals(deletionID)) {
				pw.println(data);
			}
			
		}
		pw.close();
		Bookings.delete();
		temp.renameTo(new File("Bookings.csv"));
		
		while(fileArrivalScanner.hasNextLine()) {
			
			String data = fileArrivalScanner.nextLine();
			String[] values = data.split(",");
			
			if(!values[0].contentEquals(deletionID)) {
				apw.println(data);
			}
			
		}
		apw.close();
		Arrivals.delete();
		arrivalTemp.renameTo(new File("Arrivals.csv"));
		
		while(fileDepartureScanner.hasNextLine()) {
			
			String data = fileDepartureScanner.nextLine();
			String[] values = data.split(",");
			
			if(!values[0].contentEquals(deletionID)) {
				dpw.println(data);
			}
			
		}
		dpw.close();
		Departures.delete();
		departureTemp.renameTo(new File("Departures.csv"));
		
		System.out.println("Booking Deleted.");
		
		System.out.println("\nReturning you to the Main Menu.");
		MenuObject.mainMenu();
		
	}
	
}
