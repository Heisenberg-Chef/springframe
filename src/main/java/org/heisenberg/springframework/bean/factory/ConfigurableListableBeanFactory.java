package org.heisenberg.springframework.bean.factory;

import org.heisenberg.springframework.bean.factory.config.AutowireCapableBeanFactory;
import org.heisenberg.springframework.bean.factory.config.BeanDefinition;
import org.heisenberg.springframework.bean.factory.config.BeanPostProcessor;
import org.heisenberg.springframework.bean.factory.config.ConfigurableBeanFactory;
import org.heisenberg.springframework.bean.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory , ConfigurableBeanFactory, AutowireCapableBeanFactory
{

    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}