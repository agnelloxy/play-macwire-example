package modules

import com.softwaremill.macwire._
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import dao.CompanyDAO

trait DaoModule {

  // Dependencies
  def dbConfig: DatabaseConfig[JdbcProfile]

  // dao
  lazy val companyDAO = wire[CompanyDAO]
}
