package inDriver0;

public class EventPrice extends Event {
String driverName;
double price;
public EventPrice(Event event,Driver driver, double price) {
	// TODO Auto-generated constructor stub
	super(event);
	this.driverName = driver.getUser().getUserName();
	this.price = price;
}
public String toString() {
	return eventName+" "+tripTime+" "+driverName+" "+price+"\n";
}
}
