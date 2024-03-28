package org.heisenberg.springframework.beans.factory.support;

import org.heisenberg.springframework.beans.BeansException;
import org.heisenberg.springframework.beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {

	Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
