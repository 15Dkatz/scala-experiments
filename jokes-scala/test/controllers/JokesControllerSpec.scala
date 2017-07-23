package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

class JokesControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "JokesController GET /jokes" should {
    "render the jokes page properly" in {
      val controller = new JokesController(stubControllerComponents())
      val jokes = controller.jokes().apply(FakeRequest(GET, "/jokes"))

      status(jokes) mustBe OK
      contentType(jokes) mustBe Some("text/html")
      contentAsString(jokes) must include ("Jokes")
      contentAsString(jokes) must include ("New Joke")
    }
  }

  "JokesController GET /jokes/new" should {
    "render the newJoke page properly" in {
      val controller = new JokesController(stubControllerComponents())
      val newJoke = controller.newJoke().apply(FakeRequest(GET, "/newJoke"))


      println(contentAsString(newJoke))
      status(jokes) mustBe OK
      contentType(jokes) mustBe Some("text/html")
      contentAsString(jokes) must include ("New Joke")
      contentAsString(jokes) must include ("setup")
      contentAsString(jokes) must include ("punchline")

    }
  }
}
