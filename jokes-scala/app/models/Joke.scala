package models

case class Joke(setup: String, punchline: String)

object Joke {
  var jokes = Set(
    Joke("Why did the programmer quit his job?", "Because he didn't get arrays"),
    Joke("Where do programmers drink?", "The foo bar"),
    Joke("What's Forrest Gump's password?", "1Forrest1")
  )

  def findJokes = jokes.toList

  def add(joke: Joke) {
    jokes = jokes + joke
  }
}
