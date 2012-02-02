package interaction

import spock.lang.Specification

class PublisherSubscriber2Spec extends Specification {
    def pub = new Publisher2()
    def sub1 = Mock(Subscriber2)
    def sub2 = Mock(Subscriber2)

    def setup() {
        pub.subscribers << sub1 << sub2
    }

    def "delivers messages to all active subscribers"() {
        sub1.active >> true
        sub2.active >> false

        when:
        pub.publish("msg")

        then:
        1 * sub1.receive("msg")
        0 * sub2.receive(_)
    }
}