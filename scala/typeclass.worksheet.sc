// compare with type class
case class Rational(num: Int, deno: Int)

given Ordering[Rational] with
  def compare(x: Rational, y: Rational): Int =
    x.num * y.deno - x.deno * y.num

val rationals =
  List(Rational(1, 2), Rational(2, 3), Rational(1, 5), Rational(3, 7))
rationals.sorted


// compare with subtyping
case class Rational2(num: Int, deno: Int) extends Ordered[Rational2]:
  def compare(that: Rational2): Int =
    this.num * that.deno - this.deno * that.num

val rationals2 =
  List(Rational2(1, 2), Rational2(2, 3), Rational2(1, 5), Rational2(3, 7))
rationals2.sorted

