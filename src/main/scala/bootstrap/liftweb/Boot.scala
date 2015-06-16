package bootstrap.liftweb

import net.liftweb._
import net.liftweb.common.Loggable
import net.liftweb.http.{NotFoundAsTemplate, ParsePath, S, LiftRules}
import net.liftweb.sitemap.Loc.{If, LocGroup}
import net.liftweb.sitemap.{SiteMap, Menu}
import net.liftweb.util.NamedPF

object login {
  def isLoggedIn() = true
}

class Boot /* extends Loggable */ {
  def boot: Unit = {
    LiftRules.addToPackages("jsa")


    val mainMenu = LocGroup("main")

    def ifLoggedIn = If(() => login.isLoggedIn(), () => S.redirectTo("/login"))
    def ifNotLoggedIn = If(() => !login.isLoggedIn(), () => S.redirectTo("/"))

    val entries = List(
      Menu(S ? "Home") / "index",
      Menu(S ? "Login") / "login" >> ifLoggedIn >> mainMenu,
      Menu(S ? "Logout") / "logout",
      Menu(S ? "Panel") / "panel" >> ifNotLoggedIn >> mainMenu, // this will not be visible unless isLoggedIn is true
      Menu(S ? "End") / "end"
    )

    LiftRules.setSiteMap(SiteMap(entries: _*))

    LiftRules.uriNotFound.prepend(NamedPF("404handler") {
      case (req, failure) => NotFoundAsTemplate(
        ParsePath(List("exceptions", "404"), "html", false, false))
    })

    println("Application ready")
  }
}