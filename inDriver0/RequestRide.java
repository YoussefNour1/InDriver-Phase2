package inDriver0;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class RequestRide {
	public Trip requestRide(Passenger passenger,String source,String destination, int numberOfPassengers) {
	
	Trip tempTrip = new Trip(passenger,source,destination, numberOfPassengers);
	
	if (!getDriversFavArea(tempTrip,destination))
		return null;
	
	registerAsObservers(passenger,tempTrip);
	
	    boolean Discount = Admin.getInstance(passenger.getUser()).haveDiscount(tempTrip);
	
	recivePrice(tempTrip);
	
	int choose = chooseDriver(tempTrip.getPrice(),tempTrip);
	
	passenger.notifyDriverApproval((choose-1), tempTrip, true);
	tempTrip.setDriver(Driver.getDrivers().get(choose-1));
	tempTrip.setPassenger(passenger);
	tempTrip.setPrice(tempTrip.getOffers().get(Driver.getDrivers().get(choose-1)));
	
	return tempTrip;
	}
	
	public boolean getDriversFavArea(Trip tempTrip,String destination) {

		ArrayList<Driver> allDrivers = Driver.getDrivers();
		for (int i = 0; i <allDrivers.size();i++) {
			   for (int j = 0; j < (allDrivers.get(i)).getFavouriteAreas().size(); j++) {
				if (((allDrivers.get(i)).getFavouriteAreas().get(j)).equals(destination) && (!allDrivers.get(i).getState()) ) {
					tempTrip.getSuggestedDrivers().add(allDrivers.get(i));
				}
			}
		}
		if (tempTrip.getSuggestedDrivers().size()==0) {
			   System.out.println("there's no Drivers available" );
			   return false;
		   }
		else 
			return true;
		}
	
	public void registerAsObservers(Passenger passenger,Trip tempTrip) {
		//register these drivers as observers of passenger
		for (int i = 0; i < tempTrip.getSuggestedDrivers().size(); i++) {
			passenger.registerObserver(tempTrip,tempTrip.getSuggestedDrivers().get(i));
			tempTrip.subject = passenger;
		}
		//notify them
		for (int i = 0; i < tempTrip.getSuggestedDrivers().size(); i++) {
			passenger.notifyObserversTrip(tempTrip);
		}
	}
	
	public void recivePrice(Trip tempTrip) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < tempTrip.getSuggestedDrivers().size(); i++) {
			System.out.println("Driver "+tempTrip.getSuggestedDrivers().get(i)+" ENTER THE TRIP PRICE:");
			System.out.println("Driver "+tempTrip.getSuggestedDrivers().get(i)+" ENTER THE AVAILABLE SETS: ");
			tempTrip.suggestionPrice = input.nextDouble();
			int availSets = input.nextInt();
			if (tempTrip.getNumOfPassengers() > availSets) continue;
			tempTrip.getSuggestedDrivers().get(i).notifySubject(tempTrip, tempTrip.suggestionPrice);
		}
	}
	
	public int chooseDriver(double Discount, Trip tempTrip) {
		Scanner input = new Scanner(System.in);
		System.out.println("(passenger) choose one offer: ");
		for (Map.Entry<Driver, Double> set :
			tempTrip.getOffers().entrySet()) {
           System.out.println(set.getKey() + " = "
                              + set.getValue()*Discount);
       }
		tempTrip.getOffers();
		System.out.println();
		int choose = input.nextInt();
		return choose;
	}
	
}