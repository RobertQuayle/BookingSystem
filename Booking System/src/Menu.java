import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {

	public void mainMenu() throws ParseException, IOException {
		
		CreateBooking CreateBookingObject = new CreateBooking();
		CheckAvailability CheckAvailabilityObject = new CheckAvailability();
		DisplaySchedule DisplayScheduleObject = new DisplaySchedule();
		DeleteBooking DeleteBookingObject = new DeleteBooking();
		EditBooking EditBookingObject = new EditBooking();
		
		System.out.println("\n--- Ballahowin Courtyard v1.0 ---\n");
		System.out.println("Welcome, please select an option from the menu below:\n");
		System.out.println("1. Display Reservation Schedule");
		System.out.println("2. Check Availability");
		System.out.println("3. Create New Booking");
		System.out.println("4. Edit Existing Booking");
		System.out.println("5. Delete Existing Booking");
		System.out.println("0. Exit");
		System.out.println("\nPlease input an option 1-5:");
		
		Scanner menuScanner = new Scanner(System.in);
		boolean validOption = false;
		
		while(validOption == false) {
			
			String option = menuScanner.nextLine();
			
			if(option.contentEquals("1")) {
				DisplayScheduleObject.Schedule();
				validOption = true;
			}
			else if(option.contentEquals("2")) {
				CheckAvailabilityObject.CheckAvailbility();
				validOption = true;
			}
			else if(option.contentEquals("3")) {
				CreateBookingObject.AvailabilityCheck();
				validOption = true;
			}
			else if(option.contentEquals("4")) {
				EditBookingObject.Edit();
				validOption = true;
			}
			else if(option.contentEquals("5")) {
				DeleteBookingObject.Delete();
				validOption = true;
			}
			else if(option.contentEquals("0")) {
				System.out.println("Exiting System.");
				return;
			}
			else {
				System.out.println("\nInvalid input please try again, input an option 1-5:");
			}
			
		}
		
		
	}
	
}
