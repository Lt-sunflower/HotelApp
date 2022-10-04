package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Constants;
import main.Hotel;

class HotelTest {

	Hotel hotel = new Hotel();
	
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
		Boolean b = hotel.checkOut("1B");
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
		Boolean b = hotel.clean("1B");
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
