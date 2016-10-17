package routes
import akka.http.scaladsl.server.Directives._

class Routes(healthcheckRoute: HealthcheckRoute)  {

  val routes =
    logRequestResult("akka-http-boilerplate") {
      pathPrefix("v1") {
        healthcheckRoute.healthchecks
      }
    }
}
