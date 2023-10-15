package app;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorldByJava  implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method - " + this.getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method - " + this.getClass().getSimpleName());
    }
}
