package org.heisenberg.springframework.core.convert.support;

import org.heisenberg.springframework.core.convert.converter.ConverterRegistry;
import org.heisenberg.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

public class DefaultConversionService extends GenericConversionService {
    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    /**
     * 添加默认的字符串-数字转换器
     *
     * @param converterRegistry
     */
    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
