package inDriver0;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Trip implements Discount {
	private int ID;
	private Passenger passenger;
	private Driver driver;
	private String source, destination;
	private double Price=0.0;
	private LocalTime tripTime = LocalTime.now();
        private LocalDate todaysDate = LocalDate.now();
	private static ArrayList<Trip> allTrips = new ArrayList<Trip>();
	private ArrayList<Driver> suggestedDrivers = new ArrayList<>();
	private ArrayList<Driver> observers = new ArrayList<>();
    private HashMap<Driver, Double> offers= new HashMap<Driver, Double>();
	private int numOfPassengers;
	//temporary variables
    Passenger subject;
	double suggestionPrice=0;


	Trip(Passenger passenger,String source,String destination, int numOfPassengers){
	    this.passenger=passenger;
	    this.source=source;
	    this.destination=destination;
		this.numOfPassengers = numOfPassengers;
	    this.ID = allTrips.size()+1;
            this.passenger.numOfTrips++;
	}

 
	
	public void sendRatings(double rate) {
	    driver.setDriverRating(rate);
		this.driver.calcAvgRating(rate);
	}
	
	public void setPriceSuggestion(double price) {
		suggestionPrice=price;
	}

    public void setTodaysDate(LocalDate todaysDate) {
        this.todaysDate = todaysDate;
    }

    public LocalDate getTodaysDate() {
        return todaysDate;
    }
        
	
	public Passenger getPassenger () {
		return passenger;
	}
	public void setPassenger (Passenger passenger) {
		this.passenger = passenger;
	}
	
	public Driver getDriver () {
		return driver;
	}
	
	public void setDriver (Driver driver) {
		this.driver = driver ;
	}
	public void setSource (String source) {
		this.source = source;
	}

	public String getSource () {
		return source;
	}
	public void setDestination (String destination) {
		this.destination = destination;
	}
	
	public String getDestination () {
		return destination;
	}
	
	public void setPrice (double Price) {
		this.Price = Price;
	}
	
	public void setOfferPrice(Driver driver, double price) {
		offers.put(driver, price);
	}
	public void setNumOfPassengers(int num){
		this.numOfPassengers = num;
	}
	public int getNumOfPassengers(){
		return this.numOfPassengers;
	}
	public double getPrice () {
		return Price;
	}
	public LocalTime getTime () {
		return tripTime;
	}
	public ArrayList<Driver> getSuggestedDrivers(){
		return suggestedDrivers;
	}
	public void setSuggestedDrivers(Driver driver){
		suggestedDrivers.add(driver);
	}
	public void setOffers(Driver driver, Double price){
		offers.put(driver, price);
	}
	
	public HashMap<Driver, Double> getOffers(){
		return offers;
	}
	
	public void setObservers(Driver driver){
		observers.add(driver);
	}
	
	public static void setTrip(Trip trip) {
		allTrips.add(trip);
	}
	
        @Override
	public String toString()
    {
        return "Passenger \n("+getPassenger() + ") \nDriver \n(" + getDriver() + ") \nSource: " + getSource()+
        		" |Destenation: "+getDestination()+" |Price: "+getPrice()+" |Trip Time: "+getTime()+" |Trip Date: "+getTodaysDate()+"\n";
    }

    @Override
    public double discount() {
        
            return this.Price;
        
    }
}
  

