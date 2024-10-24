package handson.zio.common

import zio.Console.*
import zio.*
import java.io.IOException

object Printer:

  def printMe(line: String): ZIO[Any, IOException, Unit] =
    printLine(s"Hi, $line!")
