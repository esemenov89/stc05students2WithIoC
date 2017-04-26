package main.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 26.04.2017.
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        Class type = bean.getClass();
        if (type.isAnnotationPresent(Benchmark.class)) {
            Object proxy = Proxy.newProxyInstance(type.getClassLoader(),type.getInterfaces(),new InvocationHandler() {

                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long before = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println("метод работал: "+(after-before)+" наносекунд");
                    return retVal;
                }
            });
            return proxy;
        } else {
            return bean;
        }
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        return bean;
    }
}