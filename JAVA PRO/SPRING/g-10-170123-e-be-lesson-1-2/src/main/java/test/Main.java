package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ClassA classA = (ClassA) context.getBean(ClassA.class);
        ClassA classA1 = (ClassA) context.getBean(ClassA.class);


    }
}
