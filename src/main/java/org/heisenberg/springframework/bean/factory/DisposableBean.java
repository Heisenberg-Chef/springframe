package org.heisenberg.springframework.bean.factory;


public interface DisposableBean {

    void destroy() throws Exception;
}
