package org.heisenberg.springframework.bean;

import org.heisenberg.springframework.bean.factory.BeanFactory;
import org.junit.jupiter.api.Test;
public class SimpleBeanContainerTest {

    @Test
    public void testGetBean()
    {

    }

    class HelloService {

        public String sayHello()
        {
            System.out.println("Hello");
            return "hello";
        }
    }
}
