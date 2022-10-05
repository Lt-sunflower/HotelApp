package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Constants;
import main.Hotel;
import main.Room;

class HotelTest {

	Hotel hotel;
	
	@BeforeEach
	void setUpBeforeEach() throws Exception {
		
		Room[] rooms = new Room[20];
		
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<5; j++)
			{
				String name = "";
				if ((i+1)%2==1)
					name = String.valueOf(i+1) + Character.toString((char)65+j);
				else 
					name = String.valueOf(i+1) + Character.toString((char)65+(5-1)-j);
				int index = i*5+j;
				Room newRoom = new Room(name, index);
				rooms[index] = newRoom;
			}
		}

		
		hotel = new Hotel(rooms);
	}

	
	@Test
	void testCheckInSuccess() {
		String s = hotel.checkIn();
		assertEquals("1A", s);
	}
	
	@Test
	void testCheckInFailure() {
		String s = null;
		for(int i=0; i<21; i++)
		{
				s = hotel.checkIn();
		}
		assertEquals(null, s);
	}
	
	@Test
	void testCheckOutSuccess() {
		hotel.checkIn();
		Boolean b = hotel.checkOut("1A");
		assertTrue(b);
	}
	
	@Test
	void testCheckOutFailure() {
		hotel.checkIn();
		Boolean b = hotel.checkOut("wrong");
		assertFalse(b);
	}

	@Test
	void testCleanSuccess() {
		hotel.checkIn();
		hotel.checkOut("1A");
		Boolean b = hotel.clean("1A");
		assertTrue(b);
	}
	
	@Test
	void testCleanFailure() {
		hotel.checkIn();
		hotel.checkOut("1A");
		Boolean b = hotel.clean("wrong");
		assertFalse(b);
	}
	
	@Test
	void testOutOfServiceSuccess() {
		hotel.checkIn();
		hotel.checkOut("1A");
		Boolean b = hotel.outOfService("1A");
		assertTrue(b);
	}
	
	@Test
	void testOutOfServiceFailure() {
		hotel.checkIn();
		hotel.checkOut("1A");
		Boolean b = hotel.outOfService("1B");
		assertFalse(b);
	}
	
	@Test
	void testRepairSuccess() {
		hotel.checkIn();
		hotel.checkOut("1A");
		hotel.outOfService("1A");
		Boolean b = hotel.repair("1A");
		assertTrue(b);
	}
	
	@Test
	void testRepairFailure() {
		hotel.checkIn();
		hotel.checkOut("1A");
		hotel.outOfService("1A");
		Boolean b = hotel.repair("1B");
		assertFalse(b);
	}
	
	@Test
	void testShowRoomsFresh() {
		int i = hotel.showRooms(Constants.ROOMSTATUS_AVAILABLE);
		assertEquals(20,i);
	}
	
	@Test
	void testShowRoomsOneCheckIn() {
		hotel.checkIn();
		int i = hotel.showRooms(Constants.ROOMSTATUS_AVAILABLE);
		assertEquals(19,i);
	}
	
	@Test
	void testShowRoomsCheckInCheckOutClean() {
		hotel.checkIn();
		hotel.checkOut("1A");
		hotel.clean("1A");
		int i = hotel.showRooms(Constants.ROOMSTATUS_AVAILABLE);
		assertEquals(20,i);
	}
	
	@Test
	void testShowRoomsNoRoomsOccupied() {
		int i = hotel.showRooms(Constants.ROOMSTATUS_OCCUPIED);
		assertEquals(0,i);
	}
	
	@Test
	void testShowRoomsNoRoomsAvailable() {
		for(int i=0; i<21; i++)
		{
			hotel.checkIn();
		}
		int i = hotel.showRooms(Constants.ROOMSTATUS_AVAILABLE);
		assertEquals(0,i);
	}
	
	@Test
	void testRoomAssignSequence2E() {
		String s=null;
		for(int i=0; i<6; i++)
		{
			s = hotel.checkIn();
		}
		assertEquals("2E",s);
	}
	
	@Test
	void testRoomAssignSequence3A() {
		String s=null;
		for(int i=0; i<11; i++)
		{
			s = hotel.checkIn();
		}
		assertEquals("3A",s);
	}

}
