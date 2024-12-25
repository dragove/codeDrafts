import scala.io.Source

val map = Source
  .fromFile("./6.txt")
  .getLines()
  .map(_.toCharArray)
  .toArray

extension (arr: Array[Array[Char]])
  def apply(idx: (Int, Int)) = arr(idx(0))(idx(1))

val h = map.length
val w = map(0).length

var current = {
  for
    i <- map.indices
    j <- map(i).indices
    if map(i)(j) == '^'
  yield (i, j)
}.head

var steper = (-1, 0)

def checkSafety(pos: (Int, Int)) =
  pos(0) >= 0 && pos(1) >= 0 && pos(0) < h && pos(1) < w
def nextSteper = steper match
  case (-1, 0) => (0, 1)
  case (0, 1)  => (1, 0)
  case (1, 0)  => (0, -1)
  case _       => (-1, 0)
def nextStep: (Int, Int) = (current(0) + steper(0), current(1) + steper(1))
map(current(0)).update(current(1), 'X')
while (checkSafety(nextStep)) {
  val guessNext = nextStep
  if map(guessNext) == '#' then
    steper = nextSteper
    current = nextStep
  else current = guessNext
  map(current(0)).update(current(1), 'X')
}
println(map.map(_.count(_ == 'X')).sum)
