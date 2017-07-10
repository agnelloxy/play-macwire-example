package modules

import play.api.db.slick.{DbName, SlickComponents}
import slick.jdbc.JdbcProfile

trait DatabaseModule extends SlickComponents {

  // DatabaseConfig
  lazy val dbConfig = slickApi.dbConfig[JdbcProfile](DbName("default"))

}
