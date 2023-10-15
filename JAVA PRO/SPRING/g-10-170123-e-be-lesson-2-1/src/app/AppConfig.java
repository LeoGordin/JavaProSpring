package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Message message() {
        Message message = new Message("This is message from Spring bean");
        return message;
    }

}
