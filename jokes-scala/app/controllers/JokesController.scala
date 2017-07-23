package controllers

import javax.inject._
import play.api.mvc._
import models.Joke

@Singleton
class JokesController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def jokes = Action {
    println("attempting to grab jokes")

    val jokes = Joke.findJokes

    // TODO use a view template
    Ok(views.html.jokes.list(jokes))
  }
}
