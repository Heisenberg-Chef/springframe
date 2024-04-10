package org.heisenberg.springframework.core.convert.support;

import org.heisenberg.springframework.core.ConversionService;
import org.heisenberg.springframework.core.convert.converter.Converter;
import org.heisenberg.springframework.core.convert.converter.ConverterFactory;
import org.heisenberg.springframework.core.convert.converter.ConverterRegistry;
import org.heisenberg.springframework.core.convert.converter.GenericConverter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GenericConversionService implements ConversionService, ConverterRegistry {

    private Map<GenericConverter.ConvertiblePair, GenericConverter> converters = new HashMap<>();

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return false;
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {

        return null;
    }

    @Override
    public void addConverter(Converter<?, ?> converter) {

    }

    @Override
    public void addConverterFactory(ConverterFactory<?, ?> converterFactory) {

    }

    @Override
    public void addConverter(GenericConverter converter) {

    }

    /**
     * Self Function.
     */
    private static GenericConverter.ConvertiblePair getRequiredType(Object object) {
        // return directly implements
        Type[] types = object.getClass().getGenericInterfaces();
        ParameterizedType parameterized = (ParameterizedType) types[0];
        Type[] actualTypeArguments = parameterized.getActualTypeArguments();
        Class<?> sourceType = (Class<?>) actualTypeArguments[0];
        Class<?> targetType = (Class<?>) actualTypeArguments[1];
        return new GenericConverter.ConvertiblePair(sourceType, targetType);
    }

    public static void main(String[] args) {
        StringToNumberConverterFactory stringToNumberConverterFactory = new StringToNumberConverterFactory();
        getRequiredType(stringToNumberConverterFactory);
    }
}
