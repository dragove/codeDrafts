import scala.io.Source

val runs = Source
  .fromFile("./1.txt")
  .getLines()
  .map(it => (if it(0) == 'L' then -1 else 1, it.drop(1).toInt))
  .toArray

// 1-1 count point to 0
val res1 = runs.foldLeft((50, 0)) { case ((current, count), (dir, num)) =>
  // in this case, we can simpliy ignore the real number
  // we just need the number be multiple of 100
  val newNum = current + num * dir
  val newCount = if newNum % 100 == 0 then count + 1 else count
  (newNum, newCount)
}

println(res1(1))

// 1-2 count point to 0 or pass 0
val res2 = runs.foldLeft((50, 0)) { case ((current, count), (dir, num)) =>
  val remain = num % 100
  val rawNewNum = current + remain * dir
  var passes = num / 100
  if current != 0 && remain > 0 && (rawNewNum <= 0 || rawNewNum >= 100) then passes = passes + 1
  val newNum =
    if rawNewNum < 0 then rawNewNum + 100
    else if rawNewNum >= 100 then rawNewNum - 100
    else rawNewNum
  (newNum, count + passes)
}
println(res2(1))
