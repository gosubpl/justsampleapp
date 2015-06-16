import net.liftweb.common.Loggable
import net.liftweb.util
import scalaz._
import Scalaz._
import net.liftweb.util.Props

object JsaProps extends Loggable {
  private def get(key: String): Option[String] = sys.props.get(key) orElse Props.get(key).toOption
  private def optional(key: String): ValidationNel[String, Option[String]] = get(key).success

}