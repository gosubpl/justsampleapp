package jsa.model

import net.liftweb.http.SessionVar

import scalaz.{NonEmptyList, Validation}

trait Login {
  object UserSession extends SessionVar[Option[User]](None)
  def user: Option[User] = UserSession.get
  def isLoggedIn = UserSession.isDefined
  def login(login: String, pass: String): Validation[NonEmptyList[String], User]
  def logout() {if (isLoggedIn) UserSession(None)}
}
