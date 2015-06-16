package pac

import im.mange.jetboot.Renderable
import im.mange.jetboot.comet.Subscriber
import im.mange.jetboot.js.JsCmdFactory
import jsa.model.Detail

import scala.xml.Text

object PanelDetailAgentLocator extends Hashable {
  val panelDetailContent = "panelDetailContent"

  def panelDetailContentId(key: String) = s"panelDetailContent_${hash(key)}"
}

case class PanelDetailAgent(sub: Subscriber) extends Renderable with JsCmdFactory {
  import PanelDetailAgentLocator._

  def render =
    <div id={panelDetailContent}>
      Hello there
    </div>

  def onShowDetail(detail: Detail) = {
    fillElement(panelDetailContent, Text(detail.toString))
  }
}
