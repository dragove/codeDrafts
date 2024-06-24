trait Foo[T]:
  def bar(y: T): T

given Foo[Int] with
  def bar(y: Int) = 12 + y

given Foo[Double] with
  def bar(y: Double) = 1.1 * y

def rua[T](x: T)(using y: Foo[T]) = y.bar(x)

rua(11)
rua(10.0)

