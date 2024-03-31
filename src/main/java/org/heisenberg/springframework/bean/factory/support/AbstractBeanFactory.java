package org.heisenberg.springframework.bean.factory.support;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.factory.FactoryBean;
import org.heisenberg.springframework.bean.factory.config.BeanPostProcessor;
import org.heisenberg.springframework.bean.factory.config.ConfigurableBeanFactory;
import org.heisenberg.springframework.core.ConversionService;
import org.heisenberg.springframework.util.StringValueResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    private final List<StringValueResolver> embeddedValueResolver = new ArrayList<>();
    /**
     * 类型转化器
     */
    private ConversionService conversionService;

    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = this.getSingleton(name);
        if (sharedInstance != null) {
            return getObjectForBeanInstance(sharedInstance, name);
        }
        return null;
    }

    /**
     * 如果是FactoryBean，那么从FactoryBean#getObject中创建bean
     * @param beanInstance
     * @param beanName
     * @return
     * @throws Exception
     */
    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) throws Exception {
        Object object = beanInstance;
        if (beanInstance instanceof FactoryBean<?>) {
            FactoryBean factoryBean = (FactoryBean) beanInstance;
            try {
                if (factoryBean.isSingleton()) {
                    // singleton 作用域bean，从缓存中获取
                    object = this.factoryBeanObjectCache.get(beanName);
                    if (object == null) {
                        // 如果缓存中没有，通过工厂生产并且放到缓存中
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName, object);
                    }
                } else {
                    // prototype
                    object = factoryBean.getObject();
                }
            } catch (Exception e) {
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
            }
        }
        return object;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }
}
