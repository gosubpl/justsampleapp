package jsa.comet

import im.mange.jetboot.comet.Subscriber
import jsa.model.Detail
import net.liftweb.http.CometActor
import pac.PanelAgent

class PanelCometActor extends CometActor with Subscriber {
  private val rootAgent = PanelAgent(PanelCometActor.this)

  override def render = rootAgent.render
}

case class Initialise()
case class ShowDetail(detail: Detail)
case class LoadFromDatabase()
