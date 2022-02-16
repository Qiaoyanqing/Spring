package core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventListener {

    protected Map<Enum, Event> events = new HashMap<>();

    public void addListener(Enum evenType, Object target, Method callBack) {
        //注册事件，通过反射调用这个方法
        events.put(evenType, new Event(target, callBack));
    }

    private void trigger(Event event) throws InvocationTargetException, IllegalAccessException {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        event.getCallback().invoke(event.getTarget(), event);
    }


    //触发事件
    protected void trigger(Enum call) throws InvocationTargetException, IllegalAccessException {
        if (!this.events.containsKey(call)) {
            return;
        }
        //存入信息
        trigger(this.events.get(call).setTrigger(call.toString()));

    }
}
