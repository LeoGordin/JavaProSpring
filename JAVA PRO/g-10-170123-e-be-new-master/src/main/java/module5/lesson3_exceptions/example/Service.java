package module5.lesson3_exceptions.example;

public class Service {

    private static OuterService outerService;

    public int calculate(int value) {
        return value + outerService.getNumber();
    }

    public static void setOuterService(OuterService outerService) {
        Service.outerService = outerService;
    }
}