package handson.zio.web

import zio.*
import zio.Console.*

import java.io.IOException
import scala.util.Try

object Main extends ZIOAppDefault:

    import handson.zio.common.Printer.*
    import handson.zio.common.Converter.*
    import handson.zio.common.Converter.given

    def run: IO[String, Unit] = myApp

    val ztry  = ZIO.fromTry(Try(54 / 0))

    private val myApp: IO[String, Unit] = for
        _ <- printLine("What's your name?"): IO[String, Unit]
        name <- readLine.convertToIO
        _ <- ZIO.fail(new IOException("Oops!")).convertToIO
        _ <- ZIO.fromTry(Try(54 / 0)).convertToIO
        personAge <- ZIO.fromOption(Some(2)).orElseFail(new RuntimeException("No age found")).convertToIO
        _ <- print(name)
    yield ()
