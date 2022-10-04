package main;

public class Room {
	
	String name;
	int priority;
	int status;
	
	public Room(String name, int priority) {
		this.name = name;
		this.priority = priority;
		this.status = Constants.ROOMSTATUS_AVAILABLE;
	}

	public String checkIn() {
		if (this.status == Constants.ROOMSTATUS_AVAILABLE) {
			this.status = Constants.ROOMSTATUS_OCCUPIED;
			return this.name;
		}
		else return null;
	}

	public Boolean checkOut() {
		if (this.status == Constants.ROOMSTATUS_OCCUPIED) {
			this.status = Constants.ROOMSTATUS_VACANT;
			return true;
		}
		else return false;

	}

	public Boolean clean() {
		if (this.status == Constants.ROOMSTATUS_VACANT) {
			this.status = Constants.ROOMSTATUS_AVAILABLE;
			return true;
		}
		else return false;
	}

	public Boolean repair() {
		if (this.status == Constants.ROOMSTATUS_REPAIR) {
			this.status = Constants.ROOMSTATUS_VACANT;
			return true;
		}
		else return false;
	}
	
	public Boolean oos() {
		if (this.status == Constants.ROOMSTATUS_VACANT) {
			this.status = Constants.ROOMSTATUS_REPAIR;
			return true;
		}
		else return false;
	}
	


}
