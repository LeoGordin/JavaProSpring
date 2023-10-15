package module6.lesson3.task7;

public class Main {

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        classA.setClassB(classB);
        classB.setClassA(classA);

        ThreadM threadM = new ThreadM();
        ThreadN threadN = new ThreadN();

        threadM.setClassA(classA);
        threadN.setClassB(classB);

        threadM.setName("Alpha");
        threadN.setName("Beta");

        threadM.start();
        threadN.start();
    }
}
