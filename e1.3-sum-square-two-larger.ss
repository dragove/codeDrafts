#lang racket

(require threading)

(define (sum-squre-two-largest lst)
  (~> lst
      (sort >)
      (take 2)
      (map (λ (x) (* x x)) _)
      (foldl + 0 _)))

(display (sum-squre-two-largest '(5 3 4)))
(newline)
