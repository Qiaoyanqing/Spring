package subject;

import core.Event;

/**
 * 监听者
 */
public class ObServer {

    /**
     * 监听者进行通知
     *
     * @param event 所通知的事件
     */
    public void advice(Event event) {
        System.out.println("=========监听========" + event);
    }
}
