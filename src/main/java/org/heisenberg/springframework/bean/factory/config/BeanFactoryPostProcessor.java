package org.heisenberg.springframework.bean.factory.config;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 所有的BeanDefinition加载完成之后，但是在bean实例化之前，提供修改BeanDefinition属性值的机会。
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
