package org.heisenberg.springframework.bean.factory.support;

import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.factory.config.AutowireCapableBeanFactory;
import org.heisenberg.springframework.bean.factory.config.BeanDefinition;
import org.heisenberg.springframework.bean.factory.config.BeanPostProcessor;
import org.heisenberg.springframework.bean.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.List;

/**
 * 抽象-自动装备能力的-Bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {
    /**
     * 无参构造初始化 - 初始化策略
     */
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();


    // from abstractBeanFactory....
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        // 如果bean需要代理对象，则直接返回代理对象

        return null;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        return null;
    }

    /**
     * 执行InstantiationAwareBeanPostProcessor的方法，如果需要代理，直接返回代理对象。
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    protected Object applyBeanPostProcessorsBeforeInstantiation(Class<?> beanClass, String beanName) {
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            // 每个Bean工厂对应一个初始化的
            if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
                Object result = ((InstantiationAwareBeanPostProcessor) beanPostProcessor).postProcessBeforeInstantiation(beanClass, beanName);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }


}
