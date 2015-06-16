package jsa.actors

import akka.actor.Actor
import im.mange.jetboot.comet.{Subscriber, Unsubscribe, Subscribe}

class MasterControlProgramActor extends Actor {
  def receive = {
    case Subscribe(sub) => subscribe(sub)
    case Unsubscribe(sub) => unsubscribe(sub)
    case msg: JsaMessage => sendToSubscribers(msg)
  }

  private var subscribers = Set[Subscriber]()

  def subscribe(s: Subscriber) {
    subscribers += s
  }

  def unsubscribe(s: Subscriber) {
    subscribers -= s
  }

  def sendToSubscribers(msg: Any) {
    subscribers.foreach(_ ! msg)
  }
}

case class JsaMessage(value: Int)
