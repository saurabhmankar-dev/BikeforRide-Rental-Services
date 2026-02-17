package rental;

public class Start {
	public static void main(String[] args) {

        RentalSystem system = new RentalSystem();

        system.addVehicle(new Bike("B1","Hero","Xtreme",500));
        system.addVehicle(new Bike("B2","Royal Enfield","Classic",700));
        system.addVehicle(new Bike("B3","Bajaj","Pulsar",600));

        system.menu();
    } 

}
