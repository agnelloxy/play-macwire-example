package modules

import com.softwaremill.macwire._
import scala.concurrent.ExecutionContext
import play.api.mvc.ControllerComponents
import controllers.AppController
import dao.CompanyDAO

trait ControllerModule {

  // Dependencies
  implicit def ec: ExecutionContext
  implicit def companyDAO: CompanyDAO
  def controllerComponents: ControllerComponents

  // Controllers
  lazy val appController = wire[AppController]

}