package controllers.twitter

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.TwitterFeedService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TwitterSearchController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  def getTweets(keyword: String) = Action.async {
    request => {
      TwitterFeedService.fetchTweets(keyword)
      Future(Ok(""))
    }
  }
}
