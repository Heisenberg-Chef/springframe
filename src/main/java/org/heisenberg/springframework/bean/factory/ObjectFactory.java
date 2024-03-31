package org.heisenberg.springframework.bean.factory;

import org.heisenberg.springframework.bean.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}