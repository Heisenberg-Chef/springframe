package org.heisenberg.springframework.beans.factory.config;

import org.heisenberg.springframework.beans.BeansException;
import org.heisenberg.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 所有的BeanDefinition加载完成之后，但是在bean实例化之前，提供修改BeanDefinition属性值的机会。
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
