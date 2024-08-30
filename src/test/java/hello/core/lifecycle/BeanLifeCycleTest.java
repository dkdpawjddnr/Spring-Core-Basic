package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTesT(){
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class); //빈으로 등록
        NetworkClient client = applicationContext.getBean(NetworkClient.class); //빈 조회
        applicationContext.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient(); //url 정보가 안들어옴
            networkClient.setUrl("http://hello-spring.dev"); //외부에서 수정자 주입을 통해서 url이 존재하게 된다.
            return networkClient;
        }
    }
}
