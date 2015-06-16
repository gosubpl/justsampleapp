package jsa.snippet

import java.util.Date
import net.liftweb.util.Helpers._

class HelloWorld {
  def howdy = "#time" #> (new Date).toString
}
