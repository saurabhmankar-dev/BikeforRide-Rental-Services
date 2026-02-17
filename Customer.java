package rental;

public class Customer {
	private String customerId;	
    private String name;

    public Customer(String id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }

}
