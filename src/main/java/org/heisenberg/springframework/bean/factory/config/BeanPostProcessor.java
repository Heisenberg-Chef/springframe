package org.heisenberg.springframework.bean.factory.config;

import org.heisenberg.springframework.bean.BeansException;

/**
 * bean的修改扩展点，有多种类继承该接口
 */
public interface BeanPostProcessor {
    /**
     * 在bean执行初始化方法之前执行方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}