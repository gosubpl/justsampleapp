package pac

import im.mange.jetboot.comet.Subscriber
import im.mange.jetboot.bootstrap3._
import im.mange.jetboot.html.{Div, Span}
import jsa.comet.Initialise
import jsa.model.Detail
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds._Noop

case class PanelAgent(sub: Subscriber) {
  private val panelSelector = PanelSelectorAgent(sub)
  private val panelDetail = PanelDetailAgent(sub)

  def render = {
    sub ! Initialise()

    Container(List(Row(List(Column(1, Span("aaa", Div("panelSelector", panelSelector))))),
      Row(List(Column(1, Span("bbb", Div("panelDetail", panelDetail))))))).render
  }

  def onInitialise() = panelSelector.onInitialise

  def onShowDetail(detail: Detail) = panelDetail.onShowDetail(detail) & panelSelector.onDetailSelected(detail)

  def onLoadFromDatabase() = _Noop // TODO: replace with load from DB
}
