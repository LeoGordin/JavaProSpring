package module6.lesson2.task4;

public class Clock extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Тик");
                Thread.sleep(1000);
                System.out.println("Так");
            } catch (InterruptedException e) {
//                System.out.println("Получена ошибка InterruptedException");
                // Если поток прерван, можем записать какую-то информацию в лог
                // Можем принудительно остановить поток
//                this.stop();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}
