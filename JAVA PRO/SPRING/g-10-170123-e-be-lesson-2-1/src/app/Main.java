package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Message message = applicationContext.getBean(Message.class);
        System.out.println(message.getMessage());

        // context.close()

    }
}
