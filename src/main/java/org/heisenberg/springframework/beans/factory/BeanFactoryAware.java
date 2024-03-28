package org.heisenberg.springframework.beans.factory;

import org.heisenberg.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
