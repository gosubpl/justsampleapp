package pac

import im.mange.jetboot.Renderable
import im.mange.jetboot.comet.Subscriber
import im.mange.jetboot.js.JsCmdFactory
import jsa.comet.LoadFromDatabase
import jsa.model.Detail

import scala.xml.{Elem, Text}

object PanelSelectorAgentLocator extends Hashable {
  val panelSelectorContent = "panelSelectorContent"

  def panelSelectorContentId(key: String) = s"panelSelectorContent_${hash(key)}"
}

case class PanelSelectorAgent(sub: Subscriber) extends Renderable with JsCmdFactory {
  import PanelSelectorAgentLocator._

  private val emptySelection = Text("Nothing there")
  private var selectedDetail: Option[Detail] = None

  def render =
    <div id={panelSelectorContent}>
      Hello there
    </div>

  def onInitialise = {
    sub ! LoadFromDatabase()

    fillElement(panelSelectorContent, emptySelection)
  }

  def onDetailSelected(detail: Detail) = {
    selectedDetail = Some(detail)

    fillElement(panelSelectorContent, Text(detail.toString))
  }
}
