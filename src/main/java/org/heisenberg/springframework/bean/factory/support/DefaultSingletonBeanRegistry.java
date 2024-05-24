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
     * 一级缓存
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 二级缓存
     */
    private Map<String, Object> earlySingletonObjects = new HashMap<>();

    /**
     * 三级缓存
     */
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();

    /**
     * Bean销毁函数
     */
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    //从三级缓存放进二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        // 加入一个单例对象
        singletonObjects.put(beanName, singletonObject); // 1
        // 删除预处理的
        earlySingletonObjects.remove(beanName); // 2
        // 删除工厂类
        singletonFactories.remove(beanName); // 3
    }

    /**
     * 加入工厂类
     *
     * @param beanName
     * @param singletonFactory
     */
    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        singletonFactories.put(beanName, singletonFactory);
    }

    /**
     * 注入Bean的销毁函数接口
     *
     * @param beanName
     * @param bean
     */
    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
