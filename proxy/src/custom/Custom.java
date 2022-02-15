package custom;

import jdk.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Custom implements MyInvocationHandler{

    private Person target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        method.invoke(this.target, args);
        return null;
    }

    public Object getInstance(Person target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }
}
