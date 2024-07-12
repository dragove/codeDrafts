def fib(n: Int): BigInt =
  def fibIter(n: Int): (BigInt, BigInt) = 
    if n == 1 then (1, 0) else
      val (a, b) = fibIter(n / 2)
      val p = (2 * b + a) * a
      val q = a * a + b * b
      if n % 2 == 0 then (p, q) else (p + q, p)
  fibIter(n)(0)

for i <- 1 to 10
  yield fib(i)
