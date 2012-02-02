package interaction

import spock.lang.Specification

class PublisherSubscriberSpec3 extends Specification {
    def pub = new Publisher()
    def sub1 = Mock(Subscriber)

    def setup() {
        pub.subscribers << sub1
    }

    def "delivers messages in the order they are published"() {
        when:
        pub.publish("msg1")
        pub.publish("msg2")

        then:
        1 * sub1.receive("msg1")

        then:
        1 * sub1.receive("msg2")
    }
}