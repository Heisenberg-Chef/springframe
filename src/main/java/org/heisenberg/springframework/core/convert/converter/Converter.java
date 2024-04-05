package org.heisenberg.springframework.core.convert.converter;

/**
 * 类型转换的抽象接口
 */
public interface Converter<S,T> {
    /**
     * 转换方法
     */
    T convert(S source);
}
