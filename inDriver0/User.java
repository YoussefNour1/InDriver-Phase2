package inDriver0;
public class User {
	
	private String userName;
	private String eMail;
	private String mobileNumber;
	private String password ;
	
	User(){
		this.userName = "";
		this.eMail = "";
		this.mobileNumber = "";
		this.password = "";
	}
	
	User(String userName, String eMail, String mobileNumber, String password ){
		this.userName = userName;
		this.eMail = eMail;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
	public String getUserName () {
		return userName;
	}
	public String getPassword () {
		return password;
	}
	public String getEMail () {
		return eMail;
	}
	public String getMobileNumber () {
		return mobileNumber;
	}
	public void setUserName (String userName) {
		this.userName = userName;
	}
	public void setPassword (String password) {
		this.password= password;
	}
	public void setEMail (String eMail) {
		this.eMail=eMail;
	}
	public void setMobileNumber (String mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	public String toString()
	{
	    return "name: "+getUserName() + ", Email: " + getEMail() + ", Mobile number: " + getMobileNumber()+ " ";
	}
	 public static void main(String[] args){
	 User userAdmin = new User ("mennaRashed", "vbnmk", "1215", "1556vdv");
     Admin.getInstance(userAdmin);
     //Admin myAdmin =new Admin(userAdmin);
     System.out.println(Admin.getInstance(userAdmin));
        

     User user = new User("ahmedRashed", "vbnmk", "1215", "1556vdv");
     Driver myDriver= new Driver(user);
     myDriver.register(user,"njvkd","cdjsk");
     System.out.println(myDriver);
     
     
     User user2 = new User("hassnaa", "vbnmk", "1215", "1556vdv");
     Driver myDriver2= new Driver(user2);
     myDriver.register(user2,"njvkd","cdjsk");
     System.out.println(myDriver2);
     

     //User userPass = new User("mahaRashed", "vbnmk", "1215", "1556vdv");
     Passenger myPassenger= new Passenger("mahaRashed", "vbnmk", "1215", "1556vdv");
     myPassenger.register(myPassenger.getUser());
     System.out.println(myPassenger);
     Passenger myPassenger2= new Passenger("mahaRashed", "vbnmk", "1215", "1556vdv");
     
     myPassenger2.register(myPassenger.getUser());
     
     myPassenger.logIn("mahaRashed", "1556vdv");
     System.out.println("log in : "+myPassenger.logIn("mahaRashed", "1556vdv"));
     System.out.println("pending : \n"+Admin.getInstance(user).getDriversPending());
     Admin.getInstance(user).verifyDriverRegestration(myDriver);
     Admin.getInstance(user).verifyDriverRegestration(myDriver2);
     System.out.println("------------");
     for (int i = 0; i < Driver.getDrivers().size(); i++) {
		System.out.println(Driver.getDrivers().get(i));
     }
     System.out.println("------------");
     System.out.println("pending : \n"+Admin.getInstance(user).getDriversPending());
     
     
     RequestRide request=new RequestRide();
     //request.requestRide(myPassenger,"Dokki", "Boulaq");
     myDriver.setFavouriteAreas("Boulaq");
     myDriver2.setFavouriteAreas("Boulaq");
     
     Trip trip = request.requestRide(myPassenger,"Dokki", "Boulaq", 1);
     
     trip.getDriver().arrivedLocation(trip);
     trip.getDriver().arrivedDestination(trip);
     
     System.out.println(myDriver2.getAvgRating());
        
    }

}






