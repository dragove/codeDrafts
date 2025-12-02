import scala.io.Source

val runs = Source
  .fromFile("./1.txt")
  .getLines()
  .map(it => (it(0), it.drop(1).toInt))
  .toArray

// 1-1 count point to 0
var current = 50
val count = runs
  .map { (op, num) =>
    if op == 'L' then current = current - num
    else current = current + num
    current % 100 == 0
  }
  .count(identity)

println(count)

// 1-2 count point to 0 or pass 0
current = 50
val count2 = runs.map { (op, num) =>
  val previous = current
  var passes = num / 100
  val remain = num % 100
  if op == 'L' then current = current - remain
  else current = current + remain
  if previous != 0 && remain > 0 && (current <= 0 || current >= 100) then passes = passes + 1
  if current < 0 then current = current + 100
  if current >= 100 then current = current - 100
  passes
}.sum
println(count2)
