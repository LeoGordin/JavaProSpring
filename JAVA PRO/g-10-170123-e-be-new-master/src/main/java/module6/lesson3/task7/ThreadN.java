package module6.lesson3.task7;

public class ThreadN extends Thread {

    private ClassB classB;

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

    @Override
    public void run() {
        classB.methodX();
    }
}
