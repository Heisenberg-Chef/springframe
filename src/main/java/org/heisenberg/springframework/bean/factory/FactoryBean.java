package org.heisenberg.springframework.bean.factory;

public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
