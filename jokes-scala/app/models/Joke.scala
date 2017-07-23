package models

case class Joke(id: Int, setup: String, punchline: String)

object Joke {
  var jokes = Set(
    Joke(0, "Why did the programmer quit his job?", "Because he didn't get arrays"),
    Joke(1, "Where do programmers drink?", "The foo bar"),
    Joke(2, "What's Forrest Gump's password?", "1Forrest1")
  )

  def findJokes = jokes.toList.sortBy(_.id)

  def findById(id: Int) = jokes.find(_.id == id)

  def add(joke: Joke) {
    jokes = jokes + joke
  }
}
