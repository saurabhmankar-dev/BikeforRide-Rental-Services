package rental;
	
public class Bike extends Vehicle implements Rentable{
	
		
	public Bike(String id, String brand, String model, double price) {
        super(id, brand, model, price);
    }

	
    @Override
    public double calculatePrice(int days) {
        double discount = (days >= 7) ? 0.9 : 1.0; // weekly discount
        return basePricePerDay * days * discount;
    }

    @Override
    public void rent() {
        isAvailable = false;
    }

    @Override
    public void returnVehicle() {
        isAvailable = true;
    }
}
