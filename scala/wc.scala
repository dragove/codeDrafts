//> using jvm 21
//> using scala 3.5.2
//> using dep com.lihaoyi::os-lib:0.11.3
//> using dep com.lihaoyi::mainargs:0.7.6

import mainargs.{main, arg, ParserForMethods, Flag}
import java.nio.file.*
import scala.jdk.CollectionConverters.*
import scala.io.Source

object Main {
  private def readInput(fileName: Option[String]) = {
    fileName match
      case Some(file) =>
        val path = Paths.get(file)
        if !Files.exists(path) then
          System.err.println(s"Error: $fileName not exists")
          System.exit(1)
        if Files.isDirectory(path) then
          System.err.println(s"Error: $fileName is a directory")
          System.exit(1)
        Files.readAllLines(path).asScala
      case None =>
        Source.stdin.getLines().toBuffer
  }

  private def countWords(s: String) =
    s.split("\\s").count(_.nonEmpty)

  @main
  def run(
      @arg(doc = "count bytes") c: Flag,
      @arg(doc = "count lines") l: Flag,
      @arg(doc = "count words") w: Flag,
      @arg(doc = "count characters") m: Flag,
      @arg(positional = true) fileName: Option[String]
  ) = {
    val lines = readInput(fileName)
    val noFlag = !(c.value || l.value || w.value || m.value)
    val output = Seq(
      if l.value || noFlag then Some(lines.size.toString) else None,
      if w.value || noFlag then Some(lines.map(countWords).sum.toString)
      else None,
      if c.value || noFlag then
        Some(lines.map(_.getBytes().length + 1).sum.toString)
      else None,
      if m.value then Some(lines.map(_.length + 1).sum.toString) else None
    ).flatten
    println((fileName.map(output :+ _).getOrElse(output)).mkString(" "))
  }

  def main(args: Array[String]): Unit =
    ParserForMethods(this).runOrExit(args.toIndexedSeq)
}
