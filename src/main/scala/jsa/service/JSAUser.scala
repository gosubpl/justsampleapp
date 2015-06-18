package jsa.service

import jsa.model.User

case class JSAUser(login: String, pass: String) extends User {
  def isAuthorised = true
}

case object JSAInvalidUser extends User {
  def login = ""
  def pass = ""
  def isAuthorised = true
}