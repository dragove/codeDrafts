//> using jvm 24
//> using scala 3.7.1
//> using dep com.lihaoyi::os-lib:0.11.4
//> using dep com.lihaoyi::mainargs:0.7.6

import java.nio.file.*
import scala.jdk.CollectionConverters.*
import scala.io.Source

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

@main def main(args: String*): Unit = {
  val flags = (for
    arg <- args
    if arg(0) == '-' && arg.length() > 1
  yield arg.drop(1)).toSet
  val (c, l, w, m) = (flags("c"), flags("l"), flags("w"), flags("m"))
  val fileName = args.find(_(0) != '-')

  val lines = readInput(fileName)
  val noFlag = !(c || l || w || m)
  val output = Seq(
    if l || noFlag then Some(lines.size.toString) else None,
    if w || noFlag then Some(lines.map(countWords).sum.toString)
    else None,
    if c || noFlag then Some(lines.map(_.getBytes().length + 1).sum.toString)
    else None,
    if m then Some(lines.map(_.length + 1).sum.toString) else None
  ).flatten

  val out = fileName.map(output :+ _).getOrElse(output).mkString(" ")
  println(out)
}
