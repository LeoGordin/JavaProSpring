package module6.lesson3.task7;

public class ClassA {

    private ClassB classB;

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    public synchronized void methodX() {
        System.out.printf("Поток %s начал выполнять метод X класса А%n",
                Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Поток %s закончил выполнять метод X класса А%n",
                Thread.currentThread().getName());

        classB.methodY();
    }

    public synchronized void methodY() {
        System.out.printf("Поток %s выполняет метод Y класса А%n",
                Thread.currentThread().getName());
    }
}
