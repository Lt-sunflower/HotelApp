package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.Constants;
import main.Room;

class RoomTest {
	
	@Before
	void init() {}
	
	@Test
	void testCheckInSuccess() {
		Room room = new Room("name",0);
		room.checkIn();
		assertEquals(Constants.ROOMSTATUS_OCCUPIED, room.getStatus());
	}
	
	@Test
	void testCheckInFailure() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_OCCUPIED);
		String s = room.checkIn();
		assertEquals(null, s);
	}
	
	@Test
	void testCheckOutSuccess() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_OCCUPIED);
		room.checkOut();
		assertEquals(Constants.ROOMSTATUS_VACANT, room.getStatus());
	}
	
	@Test
	void testCheckOutFailure() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_AVAILABLE);
		Boolean b = room.checkOut();
		assertFalse(b);
	}

	@Test
	void testCleanSuccess() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_VACANT);
		room.clean();
		assertEquals(Constants.ROOMSTATUS_AVAILABLE, room.getStatus());
	}
	
	@Test
	void testCleanFailure() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_AVAILABLE);
		Boolean b = room.clean();
		assertFalse(b);
	}
	
	@Test
	void testOutOfServiceSuccess() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_VACANT);
		room.oos();
		assertEquals(Constants.ROOMSTATUS_REPAIR, room.getStatus());
	}
	
	@Test
	void testOutOfServiceFailure() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_AVAILABLE);
		Boolean b = room.oos();
		assertFalse(b);
	}
	
	@Test
	void testRepairSuccess() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_REPAIR);
		room.repair();
		assertEquals(Constants.ROOMSTATUS_VACANT, room.getStatus());
	}
	
	@Test
	void testRepairFailure() {
		Room room = new Room("name",0,Constants.ROOMSTATUS_AVAILABLE);
		Boolean b = room.repair();
		assertFalse(b);
	}


}
