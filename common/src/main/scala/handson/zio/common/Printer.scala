package handson.zio.common

import zio.*
import zio.Console.*

import java.io.IOException

object Printer:

  import Converter.given

  def print(message: String): IO[String, Unit] =
    printLine(s"Hi, $message!")

object Converter:

  given convertToIOString: Conversion[IO[IOException, Unit], IO[String, Unit]] with
    override def apply(x: IO[IOException, Unit]): IO[String, Unit] = x.mapError(_.getMessage)

  extension [A](task: Task[A])
    def convertToIO: IO[String, A] =
      task.mapError(_.getMessage)
