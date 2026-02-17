Customer.java — Defines the customer entity with ID and name, following encapsulation principles for secure data handling.

Rentable.java — Interface that declares rental actions (rent, returnVehicle) ensuring consistent behavior across all vehicle types.

Rental.java — Model class representing a rental transaction, linking customer, vehicle, and rental duration.

Vehicle.java — Abstract base class for all vehicles containing common attributes and an abstract price calculation method for extensibility.

RentalSystem.java — Core controller class managing vehicles, customers, rentals, and user interactions. Handles booking, returns, and business logic.
