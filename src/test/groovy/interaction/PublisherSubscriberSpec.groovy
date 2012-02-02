package interaction

import spock.lang.Specification

class PublisherSubscriberSpec extends Specification {
    def pub = new Publisher()
    def sub1 = Mock(Subscriber)
    def sub2 = Mock(Subscriber)

    def setup() {
        pub.subscribers << sub2 << sub1
    }

    def "delivers messages to all subscribers"() {
        when:
        pub.publish("msg")

        then:
        1 * sub1.receive("msg")
        1 * sub2.receive("msg")
    }
}