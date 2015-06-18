package jsa.service

import jsa.model.User

class JSALoginService {
  def validate(login: String, pass: String): User = {
    new JSAUser(login, pass)
  }
}
