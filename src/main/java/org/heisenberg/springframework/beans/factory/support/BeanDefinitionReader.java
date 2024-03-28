package org.heisenberg.springframework.beans.factory.support;

import org.heisenberg.springframework.beans.BeansException;
import org.heisenberg.springframework.core.io.Resource;
import org.heisenberg.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}