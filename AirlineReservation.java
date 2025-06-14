package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    String name;
    String contactNumber;
    int seatNumber;

    public Customer(String name, String contactNumber, int seatNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.seatNumber = seatNumber;
    }
}

public class AirlineReservation {
		    static int seats[] = new int[11]; // 0: Available, 1: Reserved
		    static List<Customer> reservations = new ArrayList<>();
		    static Scanner sc = new Scanner(System.in);

		    public static void main(String[] args) {
		        System.out.println("Welcome to INDIGO");
		        while (true) {
		            System.out.println("Please select an option: ");
		            System.out.println("1. View available seats");
		            System.out.println("2. Reserve a seat");
		            System.out.println("3. Cancel a reservation");
		            System.out.println("4. Modify a reservation");
		            System.out.println("5. View reservations");
		            System.out.println("6. Total reservations count");
		            System.out.println("7. Exit");
		            int choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    displaySeats();
		                    break;
		                case 2:
		                    reserveSeat();
		                    break;
		                case 3:
		                    cancelReservation();
		                    break;
		                case 4:
		                    modifyReservation();
		                    break;
		                case 5:
		                    viewReservations();
		                    break;
		                case 6:
		                    System.out.println("Total reservations: " + reservations.size());
		                    break;   
		                case 7:
		                    System.out.println("Thank you for using INDIGO Airlines");
		                    return;
		                default:
		                    System.out.println("Invalid option. Please try again.");
		            }
		        }
		    }


			private static void viewReservations() {
				// TODO Auto-generated method stub
		    	 if (reservations.isEmpty()) {
			            System.out.println("No reservations found.");
			            return;
			        }

			        System.out.println("Current Reservations:");
			        for (Customer customer : reservations) {
			            System.out.println("Name: " + customer.name + ", Contact: " + customer.contactNumber + ", Seat: " + customer.seatNumber);
			        }
			    }
				

			private static void modifyReservation() {
				// TODO Auto-generated method stub
		    	System.out.println("Enter your current seat number (1-10): ");
		        int currentSeat = sc.nextInt();

		    
		if (currentSeat < 1 || currentSeat > 10) {
		            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
		            return;
		        }

						Customer customer = reservations.stream()
		                .filter(c.seatNumber == currentSeat)
		                .findFirst()
						.orElse(null);

		        if (customer == null) {
		            System.out.println("No reservation found for seat " + currentSeat);
		            return;
		        }

		        
		        System.out.println("Enter new seat number to reserve (1-10): ");
		        int newSeat = sc.nextInt();

		        if (newSeat < 1 || newSeat > 10) {
		            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
		            return;
		        }

		        if (seats[newSeat] == 0) {
		            
		            seats[currentSeat] = 0;
		            reservations.remove(customer);

		            
		            seats[newSeat] = 1;
		            reservations.add(new Customer(customer.name, customer.contactNumber, newSeat));
		            System.out.println("Seat changed from " + currentSeat + " to " + newSeat + " successfully.");
		        } else {
		            System.out.println("Seat " + newSeat + " is already reserved.");
		        }
		    }

				

			public static void displaySeats() {
		        System.out.println("Seats:");
		        for (int i = 1; i <= 10; i++) {
		            System.out.println("Seat " + i + ": " + (seats[i] == 0 ? "Available" : "Reserved"));
		        }
		    }

		    public static void reserveSeat() {
		        System.out.println("Enter your name: ");
		        String name = sc.next();
		        System.out.println("Enter your contact number: ");
		        String contactNumber = sc.next();
		        System.out.println("Enter seat number to reserve (1-10): ");
		        int seat = sc.nextInt();

		        if (seat < 1 || seat > 10) {
		            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
		            return;
		        }

		        if (seats[seat] == 0) {
		            seats[seat] = 1;
		            reservations.add(new Customer(name, contactNumber, seat));
		            System.out.println("Seat " + seat + " reserved successfully for " + name + ".");
		        } else {
		            System.out.println("Seat " + seat + " is already reserved.");
		        }
		    }

		    public static void cancelReservation() {
		        System.out.println("Enter seat number to cancel reservation (1-10): ");
		        int seat = sc.nextInt();

		        if (seat < 1 || seat > 10) {
		            System.out.println("Invalid seat number. Please enter a number between 1 and 10.");
		            return;
		        }

		        if (seats[seat] == 1) {
		            seats[seat] = 0;
		            reservations.removeIf(c->c.seatNumber == seat);
		            System.out.println("Reservation for seat " + seat + " canceled successfully.");
		        } else {
		            System.out.println("Seat " + seat + " is not reserved, so it cannot be canceled.");
		        }
		    }

		    
		        
		    
		      
		        


}
