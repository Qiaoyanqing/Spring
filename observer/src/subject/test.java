package subject;

import core.Event;

import java.lang.reflect.Method;

public class test {

    public static void main(String[] args) {

        try {
            //观察者
            ObServer obServer = new ObServer();
            //获取方法.class.getMethod(方法名， 参数类型（集合）)
            Method advice = ObServer.class.getMethod("advice", Event.class);
            Subject subject = new Subject();
            //注册事件
            subject.addListener(SubjectEventType.ADD, obServer, advice);
            subject.add();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
