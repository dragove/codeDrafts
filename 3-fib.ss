;; fib recursion slow version
(define (fib n)
  (if (< n 2)
    1
    (+ (fib (- n 1))
       (fib (- n 2)))))

(display (fib 3))
(newline)


;; fib iterate tail recursion version
(define (fib n)
    (define (fib-iter n r t)
      (if (= n 0)
        r
        (fib-iter (- n 1) (+ r t) r)))
  (fib-iter n 1 0))

(display (fib 3))
(newline)


