public class VehicleDemo {

    public static void main(String[] args) {

        ElectricVehicle ev =
                new ElectricVehicle(
                        "Tesla Model 3",
                        250);

        PetrolVehicle pv =
                new PetrolVehicle(
                        "Hyundai Verna",
                        220);

        ev.displayVehicle();
        ev.charge();

        System.out.println();

        pv.displayVehicle();
        pv.refuel();
    }
}