package module5.lesson2_generics.task9;

import java.util.List;

public class VehicleUtils {

    // Producer Extends, Consumer Super
    public static void moveVehicles(List<? extends Car> from, List<? super Car> to) {
        to.addAll(from);
        from.clear();
    }
}