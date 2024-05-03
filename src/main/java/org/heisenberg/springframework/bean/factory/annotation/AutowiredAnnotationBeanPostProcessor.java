package org.heisenberg.springframework.bean.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.TypeUtil;
import org.heisenberg.springframework.bean.BeansException;
import org.heisenberg.springframework.bean.PropertyValues;
import org.heisenberg.springframework.bean.factory.BeanFactory;
import org.heisenberg.springframework.bean.factory.BeanFactoryAware;
import org.heisenberg.springframework.bean.factory.ConfigurableListableBeanFactory;
import org.heisenberg.springframework.bean.factory.config.InstantiationAwareBeanPostProcessor;
import org.heisenberg.springframework.core.ConversionService;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 处理@Autowired和@Value注解的BeanPostProcessor
 */

public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    /**
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
    // 初始化方法执行之前执行
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws Exception {
        // 处理@Value注解
        Class<?> clazz = bean.getClass(); //  得到实体类型的meta
        Field[] fields = clazz.getDeclaredFields(); // 得到所有的成员变量
        Arrays.stream(fields).forEach(field -> {
            Value valueAnno = field.getAnnotation(Value.class);// 查看Field 是否标记了@Value？
            if (valueAnno != null) {
                Object value = valueAnno.value();
                value = beanFactory.resolveEmbeddedValue((String) value);
                // 类型转换
                Class<?> sourceType = value.getClass();
                Class<?> targetType = (Class<?>) TypeUtil.getType(field); // 获取字段的class
                ConversionService conversionService = beanFactory.getConversionService();
                if (conversionService != null) {
                    if (conversionService.canConvert(sourceType, targetType)) {
                        value = conversionService.convert(value, targetType);
                    }
                }
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        });

        // 处理@Autowired注解
        for (Field field : fields) {
            // 得到Autowired
            Autowired autowiredAnno = field.getAnnotation(Autowired.class);
            // 如果 有 标注Autowired注解的类
            if (autowiredAnno != null) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnno = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;
                // 有依赖注入名称
                if (qualifierAnno != null) {
                    qualifierAnno.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    // 无依赖注入名称
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return pvs;
    }
}
