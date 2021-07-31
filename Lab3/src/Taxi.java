//

public class Taxi {
	public double rate;
	public int capacity;
	public int passengers;

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        this.rate = 5.0;
        this.capacity = 4;
        this.passengers = 0;
	}
	
	public Taxi(double rate, int capacity) {
		 this.rate = rate;
	     this.capacity = capacity;
	     this.passengers = 0;
	}
	
	public double calculateFare(int passengersLeaving, int durationOfRide) {
		return passengersLeaving*this.rate + this.rate*durationOfRide;
	}
	
	public boolean pickUp(int passengersLoading) {
		if(passengersLoading <= this.capacity-this.passengers) {
        	this.passengers += passengersLoading;
        	return true;
        }
        else {
        	return false;
        }

	}

}