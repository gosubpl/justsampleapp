package jsa.model

trait User {
  def login: String
  def pass: String
  def isAuthorised: Boolean
}