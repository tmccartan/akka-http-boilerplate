
import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import routes.{Routes, HealthcheckRoute}

import scala.concurrent.ExecutionContext

object RuntimeApp extends App {
  private val config = ConfigFactory.load()
  private val httpConfig = config.getConfig("http")

  implicit val actorSystem = ActorSystem()
  implicit val executor: ExecutionContext = actorSystem.dispatcher
  implicit val log: LoggingAdapter = Logging(actorSystem, getClass)
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val httpHost = httpConfig.getString("host")
  val httpPort = httpConfig.getInt("port")

  val healthcheckRoute = new HealthcheckRoute()
  val service = new Routes(healthcheckRoute)

  Http().bindAndHandle(service.routes, httpHost, httpPort)
}
