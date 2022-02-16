package subject;

import core.EventListener;

import java.lang.reflect.InvocationTargetException;

public class Subject extends EventListener {

    //一般采用动态代理实现监控（避免代码侵入）
    public void add() throws InvocationTargetException, IllegalAccessException {
        System.out.println("添加");
        //触发监听
        trigger(SubjectEventType.ADD);
    }

    public void remove() throws InvocationTargetException, IllegalAccessException {
        System.out.println("删除");
        trigger(SubjectEventType.DELETE);
    }
}
