package jsa.view

import scala.xml.NodeSeq

object PanelView {
   def apply(): NodeSeq = {
     <div><lift:comet type="PanelCometActor"/></div>
   }

 }
