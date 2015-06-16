import net.liftweb.common.Loggable
import net.liftweb.util
import scalaz._
import Scalaz._
import net.liftweb.util.Props

object JsaProps extends Loggable {
  private def get(key: String): Option[String] = sys.props.get(key) orElse Props.get(key).toOption
  private def optional(key: String): ValidationNel[String, Option[String]] = get(key).success
  private def required(key: String): ValidationNel[String, String] = get(key).toSuccess(s"Property $key is not set").toValidationNel

  val dbName = required("jsa.db.name")
  val dbUser = required("jsa.db.user")
  val dbPass = required("jsa.db.password")

  val dbEnabled = required("jsa.db.enabled").map(_.equalsIgnoreCase("true"))

  val jsaDataLocation = optional("jsa.data.location")

  def load: ValidationNel[String, JsaProps] = {
    val db = (dbName |@| dbUser |@| dbPass)(DBProps.apply)

    val enabled = dbEnabled.map(DBEnabled.apply)

    (db |@| enabled |@| jsaDataLocation)(JsaProps.apply)
  }
}

case class DBProps(dbName: String,  dbUser: String, dbPass: String)

case class DBEnabled(isEnabled: Boolean)

case class JsaProps(dbProps: DBProps, dbEnabled: DBEnabled, dataLocation: Option[String]) {
  def apply(key: String) = JsaProps.get(key)
}