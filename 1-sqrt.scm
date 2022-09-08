(define (square x)
  (* x x))

(define (abs x)
  (if (< x 0)
      (- x)
      x))

(assert (= (abs -2)
           2))

(define (average x y)
  (/ (+ x y) 2))

(assert (= (average 4 6)
           5))

(define (improve guess x)
                 (average guess (/ x guess)))

(define (good-enough? guess x)
  (< (abs (- (square guess) x))
     0.001))

(define (sqrt-iter guess x)
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(define (sqrt x) 
  (sqrt-iter 1.0 x))

(trace sqrt-iter)

(display (sqrt 4))
(newline)

