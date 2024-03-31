package org.heisenberg.springframework.bean.factory;

import org.heisenberg.springframework.bean.BeansException;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
