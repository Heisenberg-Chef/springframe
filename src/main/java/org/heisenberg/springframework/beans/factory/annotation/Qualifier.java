package org.heisenberg.springframework.beans.factory.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Inherited // 作用影响注解继承行为
@Documented
public @interface Qualifier {
    String value() default "";

}
