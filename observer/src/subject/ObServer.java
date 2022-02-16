package subject;

import core.Event;

public class ObServer {

    public void advice(Event event) {
        System.out.println("=========监听========" + event);
    }
}
