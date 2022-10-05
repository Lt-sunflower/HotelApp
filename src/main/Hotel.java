package main;

public class Hotel {
	
	
	
	private final Room[] rooms;
	
	public Hotel(Room[] rooms) {
		
		this.rooms = rooms;
	}

	public String checkIn() {

		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].getStatus() == Constants.ROOMSTATUS_AVAILABLE)
			{
				String s = rooms[i].checkIn();
				if (s.equals(null));
				else {
					System.out.println("Room "+s);
					return rooms[i].getName();
				}
					
			}
		}
		
		System.out.println("No Rooms Available.");
		return null;
	}

	public Boolean checkOut(String roomName) {

		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].getName().equalsIgnoreCase(roomName))
			{
				Boolean b = rooms[i].checkOut();
				if (b!= true);
				else {
					System.out.println(rooms[i].getName()+ " checked out.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;

		
	}

	public int showRooms(int status) {
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].getStatus() == status)
			{
				sb.append(rooms[i].getName()+", ");
				count++;
					
			}
		}
		
		if (sb.length()>2) {
			String s = sb.substring(0, sb.length()-2);
			System.out.println(s);
		} else 
		{
			if (status == Constants.ROOMSTATUS_AVAILABLE)
				System.out.println("No available rooms.");
			else
				System.out.println("No rooms to choose from.");
			return 0;
		}

		return count;
	}

	public Boolean clean(String roomName) {
		
		for (int i=0; i<rooms.length; i++)
		{
			if (rooms[i].getName().equalsIgnoreCase(roomName))
			{
				Boolean b = rooms[i].clean();
				if (b!= true);
				else {
					System.out.println(rooms[i].getName()+ " cleaned.");
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
			if (rooms[i].getName().equalsIgnoreCase(roomName))
			{
				Boolean b = rooms[i].repair();
				if (b!= true);
				else {
					System.out.println(rooms[i].getName()+ " repaired.");
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
			if (rooms[i].getName().equalsIgnoreCase(roomName))
			{
				Boolean b = rooms[i].oos();
				if (b!= true);
				else {
					System.out.println(rooms[i].getName()+ " out of service.");
					return true;
				}
					
			}	
		}
		
		System.out.println("Room not found.");
		return false;

	}
	
}
