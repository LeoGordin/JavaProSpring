package module6.lesson5.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {

        Exchanger<Package> exchanger = new Exchanger<>();

        List<Package> packages1 = new ArrayList<>();
        packages1.add(new Package("A", "C"));
        packages1.add(new Package("A", "D"));

        List<Package> packages2 = new ArrayList<>();
        packages2.add(new Package("B", "C"));
        packages2.add(new Package("B", "D"));

        Courier courier1 = new Courier("A", "C", packages1, exchanger);
        Courier courier2 = new Courier("B", "D", packages2, exchanger);

        courier1.setAnotherCourier(courier2);
        courier2.setAnotherCourier(courier1);
    }
}
