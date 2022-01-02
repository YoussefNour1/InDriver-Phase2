package inDriver0;
import java.util.ArrayList;

public class Admin {
	static private Admin instance;
	User user;
    private ArrayList<Driver> driversPending = new ArrayList<>();
    private ArrayList<Passenger> suspendedPassengers = new ArrayList<>();
    private ArrayList<Driver> suspendedDrivers = new ArrayList<>();
    private ArrayList<String> discountAreas = new ArrayList<>();
    public ArrayList<Event> events = new ArrayList<>();
       
   	Admin(User user) {
    	this.user = user;
    }
   	
   	public ArrayList<String> getDiscountAreas(){
   		return discountAreas;
   	}
   	
   	public void setDiscountAreas(String area){
   		discountAreas.add(area);
   	}
   
    static public Admin getInstance(User user) {
    	if (instance == null) {
    		instance = new Admin(user);
    		return instance;
    	}
    	else
    		return instance;
    }
    
	public ArrayList<Driver>  getDriversPending() {
		return driversPending;
	}
	
	public ArrayList<Passenger>  getSuspendedPassengers() {
		return suspendedPassengers;
    }
	
    public ArrayList<Driver>  getSuspendedDrivers() {
		return suspendedDrivers;
	}
        
    public boolean validAccount(Passenger passenger){
        int flag=0;
        for(int i=0;i<suspendedPassengers.size();i++){
            if(passenger==suspendedPassengers.get(i)){
               flag=1;
            }
        }
        if(flag==1){
            return true;
        }
        else{ 
            return false;
        }
        
    }
    
    public boolean validAccount(Driver driver){
        int flag=0;
        for(int i=0;i<suspendedDrivers.size();i++){
            if(driver==suspendedDrivers.get(i)||driver==driversPending.get(i)){
               flag=1;
            }
        }
        if(flag==1){
            return true;
        }
        else{ 
            return false;
        }
        
    }
     
    public String verifyDriverRegestration (Driver driver){
        int flag=0;
        int j = 0;
        for(int i=0;i<driversPending.size();i++){
            if(driver==driversPending.get(i)){
               flag=1;
               j=i;
               
            }
        }
        if(flag==1){
           driversPending.remove(j);
           Driver.setDrivers(driver);
           driver.setID(Driver.getDrivers().size());
           return " The Driver has been verified";
        }
        else{ 
           return "The Driver doesn't exist in the pending list" ;
        }
    } 

    public boolean haveDiscount(Trip trip) {
    	double discount=0.9;
    	double nonDiscount=1;
    	for (int i = 0; i < getDiscountAreas().size(); i++) {
    		System.out.println(trip.getDestination());
    		System.out.println(getDiscountAreas().get(i));
    		if(trip.getDestination().equals(getDiscountAreas().get(i))) {
    			System.out.println(discount);
        		return true;
        	}
		}
    	return false;
    	
    }
    
    public void addPendingDriver(Driver driver){
        driversPending.add(driver);
    }
    
    public void addSuspendPassenger(Passenger passenger){
            suspendedPassengers.add(passenger);
    }
    
    public void addSuspendedDrivers(Driver driver){
        suspendedDrivers.add(driver);
    }
    
    public String toString(){
    	return "admin name "+ this.user.getUserName() + " |admin password "+ this.user.getPassword() + " |admin email "+ this.user.getEMail() +" |admin mobileNumber "+this.user.getMobileNumber()+"\n";
    }
    
    }
    

