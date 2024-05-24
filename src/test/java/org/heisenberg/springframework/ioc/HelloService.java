package org.heisenberg.springframework.ioc;

public class HelloService {
    HelloService() {

    }

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}