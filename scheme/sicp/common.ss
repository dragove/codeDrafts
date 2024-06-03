#lang scheme

(define (square x)
  (* x x))

(define (abs x)
  (if (< x 0)
      (- x)
      x))

(define (average x y)
  (/ (+ x y) 2))

(define nil '())

(define (gcd a b)
  (if (= b 0)
    a
    (gcd b (remainder a b))))

(provide nil)
(provide abs)
(provide gcd)
(provide square)
(provide average)
