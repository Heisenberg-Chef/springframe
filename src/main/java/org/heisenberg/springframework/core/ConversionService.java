package org.heisenberg.springframework.core;

public interface ConversionService {
    /**
     * <?> 是Class
     * @param sourceType
     * @param targetType
     * @return
     */
    boolean canConvert(Class<?> sourceType,Class<?> targetType);

    <T> T convert(Object source,Class<T> targetType);
}