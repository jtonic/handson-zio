package handson.zio.web

import zio.*
import zio.Console.*
import java.io.IOException

object Main extends ZIOAppDefault:
  
    import handson.zio.common.Printer._

    def run: ZIO[Any, IOException, Unit] = myApp

    private val myApp = for
        _ <- printLine("What's your name?")
        name <- readLine
        _ <- printMe(name)
    yield ()
