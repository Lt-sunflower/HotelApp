package main;

import java.io.Console;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		run();
	}

	private static void run() {


		
		Console console = System.console();
		
		if (console == null) {
			System.out.println("No console found.");
			return;
		}

		Hotel hotel = new Hotel();
		
		Scanner scanner = new Scanner(console.reader());
		int choice = 0;
		do {

			console.writer().println("Select an option: ");
			console.writer().println("1) Check in ");
			console.writer().println("2) Check out ");
			console.writer().println("3) Mark room cleaned ");
			console.writer().println("4) Mark room for repair ");
			console.writer().println("5) Mark room as repaired ");
			console.writer().println("6) List all available rooms ");
			console.writer().println("7) Exit ");
			
			String test = scanner.next();
			try {
				choice = Integer.parseInt(test);
			} catch (Exception e)
			{
				System.out.println("Cannot parse input to int.");
				choice = 0;
			}
			//choice = scanner.nextInt();
			
			String roomName = ""; 
			Boolean b = true;
			switch(choice) {
				case 1: 
					hotel.checkIn();
					break;
				case 2:
					console.writer().println("Enter Room number: ");
					b = hotel.showRooms(Constants.ROOMSTATUS_OCCUPIED);
					if (b) {
						roomName = scanner.next();
						hotel.checkOut(roomName);
					}
					break;
				case 3:
					console.writer().println("Enter Room number: ");
					b = hotel.showRooms(Constants.ROOMSTATUS_VACANT);
					if (b) {
						roomName = scanner.next();
						hotel.clean(roomName);
					}
					break;
				case 4:
					console.writer().println("Enter Room number: ");
					b = hotel.showRooms(Constants.ROOMSTATUS_VACANT);
					if (b) {
						roomName = scanner.next();
						hotel.outOfService(roomName);
					}
					break;
				case 5:
					console.writer().println("Enter Room number: ");
					b = hotel.showRooms(Constants.ROOMSTATUS_REPAIR);
					if (b) {
						roomName = scanner.next();
						hotel.repair(roomName);
					}
					break;
				case 6:
					hotel.showRooms(Constants.ROOMSTATUS_AVAILABLE);
					break;
				case 7:
					break;
				default:
					choice = 1;
					

					
			}
		}
		while (choice>=1 && choice<7);
		
	
		
	}

}
