package org.heisenberg.springframework.beans.factory.support;

import org.heisenberg.springframework.beans.BeansException;
import org.heisenberg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 简单的Bean实例化策略，根据Bean的构造函数进行实例化操作
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            Constructor<?> declaredConstructor = beanClass.getDeclaredConstructor();
            return declaredConstructor.newInstance(); // 进行实例化操作
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}