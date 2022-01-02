package inDriver0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private String userName;
	private String eMail;
	private String mobileNumber;
	private String password ;
        private String birthDate ;
        public   Date d1;
	User(){
		this.userName = "";
		this.eMail = "";
		this.mobileNumber = "";
		this.password = "";
		this.birthDate = "";

	}
	
	User(String userName, String eMail, String mobileNumber, String password, String birthDate ) throws ParseException{
		this.userName = userName;
		this.eMail = eMail;
		this.mobileNumber = mobileNumber;
		this.password = password;
                this.birthDate = birthDate;
                 d1=new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
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

    public String getBirthDate() {
        return birthDate;
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

        public void setBirthDate(String birthDate) {
                this.birthDate = birthDate;
        }
        
	public String toString()
	{
	    return "name: "+getUserName() + ", Email: " + getEMail() + ", Mobile number: " + getMobileNumber()+ " "+", Birth Date: " +getBirthDate()+ " ";
	}
	 public static void main(String[] args) throws ParseException{
            ArrayList<String> publicHolidays = new ArrayList<>();
publicHolidays.add("06/10");
publicHolidays.add("23/7");
publicHolidays.add("07/01");
publicHolidays.add("25/04");
publicHolidays.add("01/05");
publicHolidays.add("02/05");
publicHolidays.add("03/05");
publicHolidays.add("01/07");
publicHolidays.add("12/08");
publicHolidays.add("06/10");
publicHolidays.add("18/10");


	 User userAdmin = new User ("mennaRashed", "vbnmk", "1215", "1556vdv","12/7/2001");
     Admin.getInstance(userAdmin);
     //Admin myAdmin =new Admin(userAdmin);
     System.out.println(Admin.getInstance(userAdmin));
        

     User user = new User("ahmedRashed", "vbnmk", "1215", "1556vdv","1/1/2001");
     Driver myDriver= new Driver(user);
     myDriver.register(user,"njvkd","cdjsk");
     System.out.println(myDriver);
     
     
     User user2 = new User("hassnaa", "vbnmk", "1215", "1556vdv","2/2/2001");
     Driver myDriver2= new Driver(user2);
     myDriver.register(user2,"njvkd","cdjsk");
     System.out.println(myDriver2);
     

     //User userPass = new User("mahaRashed", "vbnmk", "1215", "1556vdv");
     Passenger myPassenger= new Passenger("mahaRashed", "vbnmk", "1215", "1556vdv","3/3/2001");
     myPassenger.register(myPassenger.getUser());
     System.out.println(myPassenger);
     Passenger myPassenger2= new Passenger("mahaRashed", "vbnmk", "1215", "1556vdv","4/4/2001");
     
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
     System.out.println(trip.toString());     
     if(myPassenger.numOfTrips==1){
         Discount a = trip;
         Discount d= new DiscountFirstRide(trip);
         d.discount();
     }
          if(Admin.getInstance(userAdmin).haveDiscount(trip)){
         Discount a = trip;
         Discount d= new DiscountFavArea(trip);
         d.discount();
     }
               if(trip.getNumOfPassengers()>1){
         Discount a = trip;
         Discount d= new DiscountMorePassenger(trip);
         d.discount();
     }
    String sub=myPassenger.getUser().d1.toString().substring(0, myPassenger.getUser().birthDate.length()-5);
    String sub2= trip.getTodaysDate().toString().substring(0, myPassenger.getUser().birthDate.length()-5);
                    if(sub==sub2){
         Discount a = trip;
         Discount d= new DiscountBirthdate(trip);
         d.discount();
     }
         if(publicHolidays.contains(sub2)){
         Discount a = trip;
         Discount d= new DiscountHolidays(trip);
         d.discount();
     }
     
     System.out.println(myDriver2.getAvgRating());
     
    }

}






