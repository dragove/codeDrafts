#lang scheme

(require "common.ss")

;; slow and memory consumption version
(define (expt a n)
  (if (= n 1)
    a
    (* a (expt a (- n 1)))))

(display (expt 2 4))
(newline)

;; slow but memory friendly version
(define (expt-mf a n)
  (define (expt-iter a n product)
    (if (= n 0)
      product
      (expt-iter a (- n 1) (* a product))))
  (expt-iter a n 1))
    
(display (expt-mf 2 4))
(newline)

(define (even? x)
  (= (remainder x 2) 0))

;; fast version by fast power
(define (expt-fast a n)
  (if (= n 1)
    a
   (if (even? n)
     (square (expt-fast a (/ n 2)))
     (* a (expt-fast a (- n 1))))))

(display (expt-fast 2 4))
(newline)

