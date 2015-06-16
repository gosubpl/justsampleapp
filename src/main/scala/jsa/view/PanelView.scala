package jsa.view

import scala.xml.NodeSeq

object PanelView {
   def apply(): NodeSeq = {
     <div><Lift:comet type="PanelCometActor"/></div>
   }

 }
