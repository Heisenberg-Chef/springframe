package org.heisenberg.springframework;

        import org.heisenberg.springframework.bean.factory.config.BeanDefinition;
        import org.heisenberg.springframework.bean.factory.support.DefaultListableBeanFactory;
        import org.heisenberg.springframework.ioc.HelloService;
        import org.junit.jupiter.api.Test;

public class SimpleBeanContainerTest {
    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}
