package org.heisenberg.springframework.bean.factory.support;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.core.io.Resource;
import org.heisenberg.springframework.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
//    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

//    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
//        this(registry, new DefaultResourceLoader());
//    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return null;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return null;
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {

    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeansException {

    }
}