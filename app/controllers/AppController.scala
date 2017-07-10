package controllers

import dao.CompanyDAO
import play.api.mvc._
import play.twirl.api.Html
import models._

import scala.concurrent.ExecutionContext

class AppController(cc: ControllerComponents, dao: CompanyDAO)
  (implicit ec: ExecutionContext) extends AbstractController(cc) {

  def index = Action.async {
    dao.findById(CompanyId(1)) map { r =>
      Ok(Html(s"<p>Hello world!</p><p>company: ${r.map(_.name)}</p>"))
    }
  }
}
