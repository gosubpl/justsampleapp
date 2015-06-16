package jsa.model

trait User {
  def login: String
  def isAuthorised: Boolean
}

case class JSAUser(login: String) extends User {
  def isAuthorised = true
}
