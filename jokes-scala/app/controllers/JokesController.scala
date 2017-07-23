package controllers

import javax.inject._
import play.api.mvc._
import models.Joke
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText}
import play.api.i18n.Messages

@Singleton
class JokesController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) with play.api.i18n.I18nSupport {
  private val jokeForm: Form[Joke] = Form(
    mapping(
      "setup" -> nonEmptyText,
      "punchline" -> nonEmptyText
    )(Joke.apply)(Joke.unapply)
  )

  def jokes = Action {
    val jokes = Joke.findJokes

    Ok(views.html.jokes.list(jokes))
  }

  def newJoke = Action { implicit request =>
    Ok(views.html.jokes.newJoke(jokeForm))
  }

  def save = Action { implicit request =>
    val newJokeForm = jokeForm.bindFromRequest()

    newJokeForm.fold(
      hasErrors = { error =>
        println(error)

        Redirect(routes.JokesController.jokes)
      },
      success = { newJoke =>
        Joke.add(newJoke)

        Redirect(routes.JokesController.jokes)
      }
    )
  }
}
