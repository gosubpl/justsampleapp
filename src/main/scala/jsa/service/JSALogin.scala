package jsa.service

import jsa.model.Login
import scalaz._
import Scalaz._

class JSALogin (jsaLoginService: JSALoginService) extends Login {

  def login(login: String, pass: String) = {
    val user = jsaLoginService.validate(login, pass)

    if (user.isAuthorised) {
      UserSession(Some(user))
      user.success
    } else {
      s"Login $login is not authorised".failure.toValidationNel
    }
  }

}
