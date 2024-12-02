import scala.io.Source
import scala.util.chaining.*
def checkSafety(arr: Array[Int]): Boolean =
  if arr.length < 2 then true
  else
    val diff = arr(1) - arr(0)
    if diff == 0 then false
    else
      val diffs = arr
        .sliding(2)
        .map(arr => arr(0) - arr(1))
      if diff > 0 then diffs.forall(x => x < 0 && x >= -3)
      else diffs.forall(x => x > 0 && x <= 3)

val inputs = Source
  .fromFile("./2.txt")
  .getLines()
  .map(_.split(" ").map(_.toInt))
  .toArray

// Part 1
inputs.count(checkSafety) pipe println

// part 2
inputs.count(input =>
  (0 until input.length).exists(i =>
    checkSafety(Array.concat(input.slice(0, i), input.slice(i + 1, input.size)))
  )
) pipe println
