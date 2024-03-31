package org.heisenberg.springframework.bean.factory.config;

import org.heisenberg.springframework.bean.factory.HierarchicalBeanFactory;
import org.heisenberg.springframework.core.ConversionService;
import org.heisenberg.springframework.util.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();
}
