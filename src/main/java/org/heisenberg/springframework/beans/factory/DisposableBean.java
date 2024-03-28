package org.heisenberg.springframework.beans.factory;


public interface DisposableBean {

	void destroy() throws Exception;
}
