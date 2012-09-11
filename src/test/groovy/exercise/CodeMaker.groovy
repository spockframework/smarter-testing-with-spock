package exercise

import groovy.transform.InheritConstructors

class CodeMaker {
  String name
  Workshop workshop

  CodeMaker(String name, Workshop workshop) {
    this.name = name
    this.workshop = workshop
  }

  void tweetAboutWorkshop(String message) {
    try {
      workshop.tweet(this, message)
    } catch (TweetException ignored) {}
  }

  void invite(CodeMaker buddy) {
    if (workshop.isRegistered(buddy)) {
      throw new FoulBuddyException("Are you trying to play a double game on me?")
    }
    if (!workshop.fullyBooked) {
      workshop.register(buddy)
    }
  }

  void bulkInvite(List<CodeMaker> buddies) {
    buddies.each { invite(it) }
  }

  String submitExercise(String solution) {
    def id = workshop.submitExercise(this, solution)
    def highScores = workshop.highScores
    def myScore = highScores.find { it.id == id }
    if (myScore == workshop.highScores[0]) {
      return "I've cracked the highscore!"
    } else {
      return "I've scored $myScore.score points"
    }
  }
}

interface Workshop {
  boolean isFullyBooked()
  boolean isRegistered(CodeMaker geek)
  List<HighScore> getHighScores()

  void register(CodeMaker geek)
  String tweet(CodeMaker geek, String message)
  int submitExercise(CodeMaker geek, String solution)
}

class HighScore {
  int id
  CodeMaker geek
  int score
}

@InheritConstructors
class FoulBuddyException extends RuntimeException {}

class TweetException extends RuntimeException {}
