package org.heisenberg.springframework.bean.factory;

import org.heisenberg.springframework.bean.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<T> requiredType) throws Exception;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    boolean containsBean(String name);
}
