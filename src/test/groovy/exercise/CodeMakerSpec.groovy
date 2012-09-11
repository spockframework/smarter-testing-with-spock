package exercise

import spock.lang.Specification

class CodeMakerSpec extends Specification {
  Workshop workshop = Mock()
  CodeMaker geek = new CodeMaker("Fred", workshop)

  def "tweets the correct message"() {
  }

  def "tweets only about himself"() {
  }

  def "stays calm when a tweet blows up"() {
  }

  def "registers a buddy when asked to invites him"() {
  }

  def "only registers a buddy if the workshop isn't booked out"() {
  }

  def "bulk-registers buddies in the order they get invited"() {
  }

  def "gets angry when asked to invite a buddy who's already registered"() {
  }

  def "honestly reports his score"() {
  }

  def "gets excited when he cracks the highscore"() {
  }
}
