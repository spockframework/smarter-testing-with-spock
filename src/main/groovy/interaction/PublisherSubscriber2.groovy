package interaction

interface Subscriber2 {
    void receive(String message)
    boolean isActive()
}

class Publisher2 {
    List<Subscriber2> subscribers = []

    void publish(String message) {
        for (subscriber in subscribers) {
            try {
                if (subscriber.active) {
                    subscriber.receive(message)
                }
            } catch (ignored) {}
        }
    }
}