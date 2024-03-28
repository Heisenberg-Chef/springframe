package org.heisenberg.springframework.stereotype;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 只能作用在类、接口、枚举
@Retention(RetentionPolicy.RUNTIME) // 不光保存在.class文件中，运行时通过反射也可以得到
@Documented
public @interface Component {
    String value() default "";
}
