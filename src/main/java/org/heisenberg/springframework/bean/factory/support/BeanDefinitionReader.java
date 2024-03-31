package org.heisenberg.springframework.bean.factory.support;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.core.io.Resource;
import org.heisenberg.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}