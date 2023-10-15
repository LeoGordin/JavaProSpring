package module6.lesson3.task7;

public class ThreadM extends Thread {

    private ClassA classA;

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    @Override
    public void run() {
        classA.methodX();
    }
}
