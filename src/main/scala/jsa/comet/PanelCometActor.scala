package jsa.comet

import im.mange.jetboot.comet.Subscriber
import jsa.model.Detail
import net.liftweb.http.CometActor
import pac.PanelAgent

class PanelCometActor extends CometActor with Subscriber {
  private val rootAgent = PanelAgent(PanelCometActor.this)

  override def render = rootAgent.render

  override def lowPriority = {
    case Initialise() => partialUpdate(rootAgent.onInitialise())
    case LoadFromDatabase() => partialUpdate(rootAgent.onLoadFromDatabase())
    case ShowDetail(d) => partialUpdate(rootAgent.onShowDetail(d))
  }
}

case class Initialise()
case class ShowDetail(detail: Detail)
case class LoadFromDatabase()
