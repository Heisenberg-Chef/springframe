package org.heisenberg.springframework.core.convert.support;

import org.heisenberg.springframework.core.ConversionService;
import org.heisenberg.springframework.core.convert.converter.Converter;
import org.heisenberg.springframework.core.convert.converter.ConverterFactory;
import org.heisenberg.springframework.core.convert.converter.ConverterRegistry;
import org.heisenberg.springframework.core.convert.converter.GenericConverter;

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
}
