package inDriver0;

import java.util.ArrayList;

public class Driver implements Observer {

    private double avgRating = 0;
    private String drivingLicense;
    private String nationalID;
    private User user;
    private int ID;
    private boolean busy;
    private static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    private ArrayList<String> favouriteAreas = new ArrayList<>();
    private ArrayList<Double> usersRating = new ArrayList<>();
    private ArrayList<Trip> offers = new ArrayList<>();
    private int availableSets;

    Driver(User Userr) {
        this.user = Userr;
        Admin.getInstance(user).addPendingDriver(this);
        busy = false;
    }

    public void register(User userData, String drivingLicense, String nationalID) {
        for (int i = 0; i < Driver.allDrivers.size(); i++) {
            if (userData.getUserName().equals(Driver.allDrivers.get(i).user.getUserName())) {
                System.out.println("Username token");
                return;
            }
        }
        this.user = userData;
        this.drivingLicense = drivingLicense;
        this.nationalID = nationalID;
    }

    public boolean logIn(String userName, String password) {
        for (int i = 0; i < Admin.getInstance(user).getSuspendedDrivers().size(); i++) {
            if (userName.equals(Admin.getInstance(user).getSuspendedDrivers().get(i).user.getUserName())) {
                System.out.println("User suspended");
                return false;
            }
        }
        if (this.user.getUserName().equals(userName) && this.user.getPassword().equals(password)) {
            return true;
        } else
            return false;
    }

    public void setAvailableSets(int availableSets) {
        this.availableSets = availableSets;
    }

    public int getAvailableSets() {
        return this.availableSets;
    }

    public void calcAvgRating(double rate) {
        int n = usersRating.size();
        avgRating = (avgRating + rate) / n;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public String getDriverLicense() {
        return drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }

    public User getUser() {
        return user;
    }

    public int getID() {
        return ID;
    }

    public void getState(boolean state) {
        busy = state;
    }

    public boolean getState() {
        return busy;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public static ArrayList<Driver> getDrivers() {
        return allDrivers;
    }

    public static void setDrivers(Driver driver) {
        allDrivers.add(driver);
    }

    public ArrayList<String> getFavouriteAreas() {
        return favouriteAreas;
    }

    public ArrayList<Double> getDriverRating() {
        return usersRating;
    }

    public void setDriverRating(Double rate) {
        usersRating.add(rate);
    }

    public void setFavouriteAreas(String area) {
        favouriteAreas.add(area);
    }

    public void arrivedLocation(Trip trip) {
        System.out.println("Driver arrived to the location.");
        Event newEvent = new Event("arrived location");
        Event newEventArrival = new EventArrival(newEvent, trip);
        Admin.getInstance(user).events.add(newEventArrival);

    }

    public void arrivedDestination(Trip trip) {
        System.out.println("Driver arrived to the destination.");
        Event newEvent = new Event("arrived destination");
        Event newEventArrival = new EventArrival(newEvent, trip);
        Admin.getInstance(user).events.add(newEventArrival);
        this.notifyArrival(trip);
        this.busy = false;
    }

    @Override
    public void notifySubject(Trip trip, double price) {
        // TODO Auto-generated method stub
        trip.subject.update(trip, this, trip.suggestionPrice);
        Event newEvent = new Event("driver puting a price");
        Event newEventArrival = new EventPrice(newEvent, this, price);
        Admin.getInstance(user).events.add(newEventArrival);
    }

    @Override
    public void update(Trip t) {
        this.offers.add(t);
    }

    @Override
    public void update(Trip trip, boolean b) {
        if (b) {
            System.out.println("the driver in the way.");
            this.busy = true;
            Trip.setTrip(trip);
        } else
            System.out.println("the trip cancelled");
    }

    @Override
    public void notifyArrival(Trip trip) {
        trip.subject.updateArrival(trip);
    }

    public String toString() {
        return "driver ID " + this.ID + " |driver name " + this.user.getUserName() + " |driver password " + this.user.getPassword() + " |driver email " + this.user.getEMail() + " |driver mobileNumber " + this.user.getMobileNumber() + "\n";
    }


}

    

