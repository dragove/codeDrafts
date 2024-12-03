import scala.util.matching.Regex
import scala.io.Source
import scala.util.chaining.*

val lines = Source
  .fromFile("./3.txt")
  .getLines()
  .toArray

// Part 1
val regex1 = "mul\\((\\d*),(\\d*)\\)".r
lines
  .flatMap(regex1.findAllMatchIn)
  .map(m => m.group(1).toInt * m.group(2).toInt)
  .sum pipe println

// Part2
val regex2 = "mul\\((\\d*),(\\d*)\\)|do\\(\\)|don't\\(\\)".r
var enabled = true
lines
  .flatMap(regex2.findAllMatchIn)
  .map(m =>
    m.group(0) match
      case "do()" =>
        enabled = true
        0
      case "don't()" =>
        enabled = false
        0
      case _ =>
        if enabled then m.group(1).toInt * m.group(2).toInt
        else 0
  )
  .sum pipe println
