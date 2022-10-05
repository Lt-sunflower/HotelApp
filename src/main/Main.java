package main;

import java.io.Console;
import java.util.Scanner;

public class Main {

	final static int NUMBER_OF_FLOORS = 4;
	final static int NUMBER_OF_ROOMS = 5;
	
	static Room[] rooms = new Room[NUMBER_OF_FLOORS*NUMBER_OF_ROOMS];
	
	public static void main(String[] args) {

		init();
		run();
	}

	private static void init() {

		for (int i=0; i<NUMBER_OF_FLOORS; i++)
		{
			for (int j=0; j<NUMBER_OF_ROOMS; j++)
			{
				String name = "";
				if ((i+1)%2==1)
					name = String.valueOf(i+1) + Character.toString((char)65+j);
				else 
					name = String.valueOf(i+1) + Character.toString((char)65+(NUMBER_OF_ROOMS-1)-j);
				int index = i*NUMBER_OF_ROOMS+j;
				Room newRoom = new Room(name, index);
				rooms[index] = newRoom;
			}
		}
		
	}

	private static void run() {


		
		Console console = System.console();
		
		if (console == null) {
			System.out.println("No console found.");
			return;
		}

		Hotel hotel = new Hotel(rooms);
		
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
				System.out.println("Invalid input");
				choice = 0;
			}
			//choice = scanner.nextInt();
			
			String roomName = ""; 
			int count = 0;
			switch(choice) {
				case 1: 
					hotel.checkIn();
					break;
				case 2:
					console.writer().println("Enter Room number: ");
					count = hotel.showRooms(Constants.ROOMSTATUS_OCCUPIED);
					if (count > 0) {
						roomName = scanner.next();
						hotel.checkOut(roomName);
					}
					break;
				case 3:
					console.writer().println("Enter Room number: ");
					count = hotel.showRooms(Constants.ROOMSTATUS_VACANT);
					if (count > 0) {
						roomName = scanner.next();
						hotel.clean(roomName);
					}
					break;
				case 4:
					console.writer().println("Enter Room number: ");
					count = hotel.showRooms(Constants.ROOMSTATUS_VACANT);
					if (count > 0) {
						roomName = scanner.next();
						hotel.outOfService(roomName);
					}
					break;
				case 5:
					console.writer().println("Enter Room number: ");
					count = hotel.showRooms(Constants.ROOMSTATUS_REPAIR);
					if (count > 0) {
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
