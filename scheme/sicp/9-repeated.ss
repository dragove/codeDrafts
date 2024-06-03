#lang scheme

;; multiply by recursion
(define (mul a b)
  (if (= b 0)
    0
    (+ a (mul a (- b 1)))))

(display (mul 4 6))
(newline)

;; A, Integer -> A
;; exponential
(define (exp a b)
  (if (= b 0)
    1
    (mul a (exp a (- b 1)))))

(display (exp 3 3))
(newline)


