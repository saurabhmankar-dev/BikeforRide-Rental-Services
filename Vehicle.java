package rental;

public abstract class Vehicle {  
	
	    protected String id;
	    protected String brand;
	    protected String model;
	    protected double basePricePerDay;
	    protected boolean isAvailable = true;

	    public Vehicle(String id, String brand, String model, double basePricePerDay) {
	        this.id = id;
	        this.brand = brand;
	        this.model = model;
	        this.basePricePerDay = basePricePerDay;
	    }

	    public String getId() { return id; }
	    public String getBrand() { return brand; }
	    public String getModel() { return model; }
	    public boolean isAvailable() { return isAvailable; }

	    public abstract double calculatePrice(int days);
	

}
