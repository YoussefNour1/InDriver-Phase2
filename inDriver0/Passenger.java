package inDriver0;
import inDriver0.Admin;
import java.text.ParseException;
import java.util.*;

public class Passenger implements Subject{
	private User user;
        	public int numOfTrips;
	private ArrayList<Trip> trips= new ArrayList <>();
	private static ArrayList<Passenger> allPassengers = new ArrayList<Passenger>();
	
	public Passenger(String userName, String eMail, String mobileNumber, String password,String birthDate ) throws ParseException{
	    	
	    	user = new User(userName, eMail, mobileNumber, password,birthDate );
	    	numOfTrips=0;
	}
	
	public void register(User userData) {
		try {
			for (int i = 0; i < Passenger.allPassengers.size(); i++) {
				if(userData.getUserName().equals(Passenger.allPassengers.get(i).user.getUserName())) {
					System.out.println("Username token");
					return;
				}
			}
			this.user = userData;
			Passenger.allPassengers.add(this);	
			return ;
		}catch (Exception e) {
			return ;
		}
		
	}
	
	public boolean logIn(String userName, String password) {
	    	for (int i = 0; i < Admin.getInstance(user).getSuspendedPassengers().size(); i++) {
	    		if(userName.equals(Admin.getInstance(user).getSuspendedPassengers().get(i).user.getUserName())) {
	    			System.out.println("User suspended");
	    			return false;
	    		}
	    	}
	    	if(this.user.getUserName().equals(userName) && this.user.getPassword().equals(password)) {
	    		return true;
	    	}
	    	else 
	    		return false;
	    }

	public void setUser(User user) {
		this.user= user;
	}
	
	public User getUser() {
		return user;
	}
	
	public double getRate (Driver driver) {
		return driver.getAvgRating();
	}
	
	public void rateDriver (Trip trip, double rate) {
		trip.sendRatings(rate);
	}
	
	@Override
	public void registerObserver(Trip trip, Driver d) {
		// TODO Auto-generated method stub
		trip.setObservers(d);
	}
	
	@Override
	public void removeObserver(Trip trip, Driver d) {
		// TODO Auto-generated method stub
		int observerIndex = trip.getSuggestedDrivers().indexOf(d); //Do I have this observer?
	    if (observerIndex >= 0) {
	    	trip.getSuggestedDrivers().remove(observerIndex);
	    }
	}
	
	@Override
	public void notifyObserversTrip(Trip trip) {
		// TODO Auto-generated method stub
		trip.getSuggestedDrivers().forEach(o -> o.update(trip));
	}
	
	@Override
	public void notifyDriverApproval(int choose, Trip trip, boolean b) {
		// TODO Auto-generated method stub
		Driver.getDrivers().get(choose).update(trip, b);
	}
	
	@Override
	public void update(Trip trip, Driver driver, double price) {
		// TODO Auto-generated method stub
		trip.setOffers(driver,price);
	}
	
	@Override
	public void updateArrival(Trip trip) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("(Passenger) rate the driver from 1 to 5 : ");
		double rate = input.nextDouble();
		this.notifyDriverRate(trip, rate);
		
	}
	
	@Override
	public void notifyDriverRate(Trip trip, double rate) {
		// TODO Auto-generated method stub
		this.rateDriver(trip, rate);
	}
	
	public String toString(){
				return "passenger name "+ this.user.getUserName() + " passenger password "+ this.user.getPassword() + " passenger email "+  this.user.getEMail() +" passenger mobileNumber "+this.user.getMobileNumber()+"\n";
			}
	
}