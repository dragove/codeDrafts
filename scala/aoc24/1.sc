import scala.util.chaining.*
import scala.io.Source
val arrays = Source
  .fromFile("./1.txt")
  .getLines()
  .map(_.split("\\s+").map(_.toInt))
  .toArray
  .transpose

// part 1
arrays
  .map(_.sorted)
  .reduce((a, b) => a.zip(b).map((x, y) => math.abs(x - y)))
  .sum pipe println

// part 2
val m = arrays(1).groupMapReduce(identity)(_ => 1)(_ + _)
arrays(0)
  .map(x => x * m.getOrElse(x, 0))
  .sum pipe println
