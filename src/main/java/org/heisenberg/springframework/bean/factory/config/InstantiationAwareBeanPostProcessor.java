package org.heisenberg.springframework.bean.factory.config;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.PropertyValues;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * bean实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws Exception;

    /**
     * 提前暴露bean
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
