package module6.lesson1.task3;

public class SingleThread {

    public static void main(String[] args) {

        int count = 0;

        for (int i = 2; i < 100000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("Total numbers of prime: " + count);
    }
}