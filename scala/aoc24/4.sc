import scala.io.Source
import scala.util.chaining.*

val data = Source
  .fromFile("./4.txt")
  .getLines()
  .map(_.toCharArray)
  .toArray

// Part 1
val pattern = "XMAS"

val directions = (for
  i <- -1 to 1
  j <- -1 to 1
yield (i, j)).filter(_ != (0, 0))

def checkBound(x: Int, y: Int) =
  x >= 0 && y >= 0 && x < data.length && y < data(x).length

def matchDir(x: Int, y: Int, dir: (Int, Int)): Boolean =
  (0 until 4).forall(i =>
    val nx = x + dir(0) * i
    val ny = y + dir(1) * i
    checkBound(nx, ny) && data(nx)(ny) == pattern(i)
  )

def search(x: Int, y: Int): Int = directions.count(dir => matchDir(x, y, dir))

val allCount = (for
  x <- 0 until data.length
  y <- 0 until data(x).length
yield search(x, y)).sum pipe println

// Part 2
((for
  x <- 0 to data.length - 3
  y <- 0 to data(x).length - 3
yield
  val concat = String(
    Array(data(x)(y), data(x)(y + 2), data(x + 2)(y + 2), data(x + 2)(y))
  )
  if data(x + 1)(y + 1) == 'A' &&
    List("MMSS", "MSSM", "SSMM", "SMMS").contains(concat)
  then 1
  else 0
)).sum pipe println
