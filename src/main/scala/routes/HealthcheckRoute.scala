package routes

import akka.http.scaladsl.server.Directives._

class HealthcheckRoute() {

  val healthchecks =
    pathPrefix("healthcheck") {
      get {
        complete("ok")
      }
    }

}
