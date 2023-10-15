package module6.lesson3.task7;

public class ClassB {

    private ClassA classA;

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    public synchronized void methodX() {
        System.out.printf("Поток %s начал выполнять метод X класса B%n",
                Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Поток %s закончил выполнять метод X класса B%n",
                Thread.currentThread().getName());

        classA.methodY();
    }

    public synchronized void methodY() {
        System.out.printf("Поток %s выполняет метод Y класса B%n",
                Thread.currentThread().getName());
    }
}
