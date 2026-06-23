class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
}

public class VehicleDemo {

    static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars:");
        for(Vehicle v : vehicles) {
            if(v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes:");
        for(Vehicle v : vehicles) {
            if(v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Vehicle("UP01","Aman","Car"),
                new Vehicle("UP02","Rahul","Bike"),
                new Vehicle("UP03","Priya","Car"),
                new Vehicle("UP04","Neha","Bike"),
                new Vehicle("UP05","Rohan","Car"),
                new Vehicle("UP06","Kunal","Bike"),
                new Vehicle("UP07","Aryan","Car"),
                new Vehicle("UP08","Anjali","Bike"),
                new Vehicle("UP09","Ritika","Car"),
                new Vehicle("UP10","Pooja","Bike")
        };

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}