package org.heisenberg.springframework.core.convert.support;

import org.heisenberg.springframework.core.convert.converter.Converter;
import org.heisenberg.springframework.core.convert.converter.ConverterFactory;

/**
 * 只能转换Long 和 Integer，否则会引发异常。
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<T>(targetType);
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.length() == 0) {
                return null;
            }
            if (targetType.equals(Integer.class)) {
                return (T) Integer.valueOf(source);
            } else if (targetType.equals(Long.class)) {
                return (T) Long.valueOf(source);
            } else {
                throw new IllegalArgumentException("Cannot convert String [" + source + "] to target class [" + targetType.getName() + "]");
            }
        }
    }
}
