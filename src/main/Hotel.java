package main;

public class Hotel {
	
	final int NUMBER_OF_FLOORS = 4;
	final int NUMBER_OF_ROOMS = 5;
	
	private Room[] rooms = new Room[20];
	
	public Hotel() {
		
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

	public Boolean checkIn() {

		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].status == Constants.ROOMSTATUS_AVAILABLE)
			{
				String s = rooms[i].checkIn();
				if (s.equals(null));
				else {
					System.out.println("Room "+s);
					return true;
				}
					
			}
		}
		
		System.out.println("No Rooms Available.");
		return false;
	}

	public Boolean checkOut(String roomName) {

		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].name.equals(roomName))
			{
				Boolean b = rooms[i].checkOut();
				if (b!= true);
				else {
					System.out.println(rooms[i].name+ " checked out.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;

		
	}

	public Boolean showRooms(int status) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].status == status)
			{
				sb.append(rooms[i].name+", ");
					
			}
		}
		
		if (sb.length()>2) {
			String s = sb.substring(0, sb.length()-2);
			System.out.println(s);
		} else 
		{
			System.out.println("No rooms to choose from.");
			return false;
		}

		return true;
	}

	public Boolean clean(String roomName) {
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].name.equals(roomName))
			{
				Boolean b = rooms[i].clean();
				if (b!= true);
				else {
					System.out.println(rooms[i].name+ " cleaned.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;
		
	}

	public Boolean repair(String roomName) {
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].name.equals(roomName))
			{
				Boolean b = rooms[i].repair();
				if (b!= true);
				else {
					System.out.println(rooms[i].name+ " repaired.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;
		
	}

	public Boolean outOfService(String roomName) {
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].name.equals(roomName))
			{
				Boolean b = rooms[i].oos();
				if (b!= true);
				else {
					System.out.println(rooms[i].name+ " out of service.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;

	}
	
}
