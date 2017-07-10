package models

import org.joda.time.DateTime

case class Company(id: Option[CompanyId], name: String, created: DateTime)
case class CompanyId(value: Long)
