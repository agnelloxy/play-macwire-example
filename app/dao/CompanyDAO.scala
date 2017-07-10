package dao

import java.sql.Timestamp

import scala.concurrent.Future
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import models._
import org.joda.time.DateTime
import com.github.tototoshi.slick.converter.JodaDateTimeSqlTimestampConverter

class CompanyDAO(val dbConfig: DatabaseConfig[JdbcProfile]) extends CompanyDAOLike
  with JodaDateTimeSqlTimestampConverter {

  import dbConfig.profile.api._
  val db = dbConfig.db

  implicit def timestamp2dateTime =  MappedColumnType.base[DateTime, Timestamp](toSqlType, fromSqlType)
  implicit def companyMapper = MappedColumnType.base[CompanyId, Long](_.value, CompanyId)

  class CompanyTable(tag: Tag) extends Table[Company](tag, "companies") {
    def id      = column[CompanyId]("id", O.PrimaryKey, O.AutoInc)
    def name    = column[String]("name", O.SqlType("VARCHAR(255)"))
    def created = column[DateTime]("created", O.SqlType("DATETIME"))

    def * = (id.?, name, created) <> (Company.tupled, Company.unapply)
  }

  val companies = TableQuery[CompanyTable]

  def findById(id: CompanyId) = db.run(companies.filter(_.id === id).result.headOption)

}

trait CompanyDAOLike {

  def findById(id: CompanyId): Future[Option[Company]]

}
