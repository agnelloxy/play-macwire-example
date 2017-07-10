package modules

import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.i18n._
import play.api.routing.Router
import router.Routes
import scala.concurrent.ExecutionContext

class MyApplicationLoader extends ApplicationLoader {
  def load(context: Context): play.api.Application = new MyComponents(context).application
}

class MyComponents(context: Context)
  extends BuiltInComponentsFromContext(context)
  with DatabaseModule
  with DaoModule
  with ControllerModule
  with AssetsComponents
  with I18nComponents
  with play.filters.HttpFiltersComponents {

  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  // set up logger
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }

  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }
}
