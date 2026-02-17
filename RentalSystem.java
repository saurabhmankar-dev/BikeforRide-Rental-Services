package rental;

import java.util.*;

public class RentalSystem {
	 
	
	
	
	private List<Vehicle> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addVehicle(Vehicle v) { vehicles.add(v); }

    public void menu() {
        while (true) {
            System.out.println("\n===== BikeforRide Rental Services =====");
            System.out.println("1. Rent Bike");
            System.out.println("2. Return Bike");
            System.out.println("3. Exit");

            int choice = getIntInput("Choose option: ");

            switch (choice) {
                case 1 -> rentFlow();
                case 2 -> returnFlow();
                case 3 -> { System.out.println("Thank you! Visit Again:)"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void rentFlow() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("\nAvailable Bikes:");
        vehicles.stream()
                .filter(Vehicle::isAvailable)
                .forEach(v -> System.out.println(v.getId()+" "+v.getBrand()+" "+v.getModel()));

        System.out.print("Enter Bike ID: ");
        String id = scanner.nextLine();

        Vehicle selected = vehicles.stream()
                .filter(v -> v.getId().equalsIgnoreCase(id) && v.isAvailable())
                .findFirst().orElse(null);

        if (selected == null) {
            System.out.println("Invalid bike.");
            return;
        }

        int days = getIntInput("Enter days: ");

        Customer c = new Customer("C" + (customers.size()+1), name);
        customers.add(c);

        double price = selected.calculatePrice(days);

        System.out.println("Total Price: ₹" + price);
        System.out.print("Confirm (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            ((Rentable)selected).rent();
            rentals.add(new Rental(selected,c,days));
            System.out.println("Bike rented successfully.");
        }
    }

    private void returnFlow() {
        System.out.print("Enter Bike ID: ");
        String id = scanner.nextLine();

        Rental rental = rentals.stream()
                .filter(r -> r.getVehicle().getId().equalsIgnoreCase(id))
                .findFirst().orElse(null);

        if (rental == null) {
            System.out.println("Invalid ID.");
            return;
        }

        ((Rentable)rental.getVehicle()).returnVehicle();
        rentals.remove(rental);

        System.out.println("Returned by "+rental.getCustomer().getName());
    }

    private int getIntInput(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Enter valid number.");
            }
        }
    }
}
