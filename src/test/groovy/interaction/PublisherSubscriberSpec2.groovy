package interaction

import spock.lang.Specification

class PublisherSubscriberSpec2 extends Specification {
    def pub = new Publisher()
    def sub1 = Mock(Subscriber)
    def sub2 = Mock(Subscriber)

    def setup() {
        pub.subscribers << sub1 << sub2
    }

    def "can cope with misbehaving subscribers"() {
        when:
        pub.publish("msg")

        then:
        1 * sub1.receive("msg") >> { throw new Exception() }
        1 * sub2.receive("msg")
    }
}