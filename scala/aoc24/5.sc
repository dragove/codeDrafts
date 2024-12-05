import scala.annotation.retains
import scala.io.Source
import scala.util.chaining.*

val lines = Source
  .fromFile("./5.txt")
  .getLines()
  .toArray

val splited = lines.splitAt(lines.indexOf(""))
val pairs = splited(0)
val testLines = splited(1).drop(1)

val testNumbers = testLines.map(_.split(",").map(_.toInt))
val checkings = pairs
  .map: it =>
    val sp = it.split("\\|")
    (sp(1).toInt, sp(0).toInt)
  .toSet

def test(ints: Array[Int]): Option[(Int, Int)] =
  val intPairs = for
    i <- 0 until ints.length - 1
    j <- i + 1 until ints.length
  yield (i, j)
  intPairs.find((i, j) => checkings(ints(i), ints(j)))

testNumbers
  .filter(test(_) == None)
  .map: it =>
    it(it.length / 2)
  .sum pipe println

def correct(arr: Array[Int]): Array[Int] =
  val testRes = test(arr)
  testRes match
    case None         => arr
    case Some((i, j)) => correct(arr.updated(i, arr(j)).updated(j, arr(i)))

testNumbers
  .filter(test(_) != None)
  .map: it =>
    val corrected = correct(it)
    corrected(it.length / 2)
  .sum pipe println
