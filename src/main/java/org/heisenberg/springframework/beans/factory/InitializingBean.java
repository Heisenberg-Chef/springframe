package org.heisenberg.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
