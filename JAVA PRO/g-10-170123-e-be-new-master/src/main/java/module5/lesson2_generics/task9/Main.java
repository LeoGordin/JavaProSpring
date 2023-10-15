package module5.lesson2_generics.task9;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> hangar = new ArrayList<>();

        hangar.add(new Airplane());
        hangar.add(new Boat());
        hangar.add(new Honda());

        List<Honda> garage = new ArrayList<>();

        garage.add(new Honda());
        garage.add(new Honda());
        garage.add(new Honda());

        System.out.println("Содержимое ангара: " + hangar);
        System.out.println("Содержимое гаража: " + garage);

        VehicleUtils.moveVehicles(garage, hangar);

        System.out.println("Содержимое ангара: " + hangar);
        System.out.println("Содержимое гаража: " + garage);

        List<Car> parking = new ArrayList<>();
        List<Toyota> toyotaGarage = new ArrayList<>();

        VehicleUtils.moveVehicles(toyotaGarage, parking);

        List<Boat> boats = new ArrayList<>();
        List<Audi> audiGarage = new ArrayList<>();

//        VehicleUtils.moveVehicles(boats, audiGarage);
    }
}
