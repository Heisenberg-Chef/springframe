package org.heisenberg.springframework.beans.factory;

import org.heisenberg.springframework.beans.BeansException;

public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}