#lang scheme

;; f = n if n < 3
;; f = f(n - 1) + 2f(n - 2) + 3f(n - 3)

(define (f n)
  (define (f-iter a b c count)
    (if (= count 0)
      a
      (f-iter b c (+ c (* 2 b) (* 3 a)) (- count 1))))
  (f-iter 0 1 2 n))

(display (map f (range 10)))
(newline)
