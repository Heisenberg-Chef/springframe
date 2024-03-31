package org.heisenberg.springframework.bean.factory.support;

import org.heisenberg.springframework.bean.factory.config.SingletonBeanRegistry;
import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.factory.DisposableBean;
import org.heisenberg.springframework.bean.factory.ObjectFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 单例Bean注册实现类
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 一级缓存 - 完全初始化了
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 二级缓存 - 还有值未注入
     */
    private Map<String, Object> earlySingletonObjects = new HashMap<>();

    /**
     * 三级缓存 - bean工厂
     */
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    // 接口定义的方法，用来生产一个Bean
                    singletonFactory.getObject();
                    // 从三级缓存放进二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destorySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        beanNames.stream().forEach(
                e -> {
                    DisposableBean remove = disposableBeans.remove(e);
                    try {
                        remove.destroy();
                    } catch (Exception exception) {
                        throw new BeansException("Destroy method on bean with name '" + e + "' threw an exception", exception);
                    }
                }
        );
    }
}
