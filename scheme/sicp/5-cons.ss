#lang scheme

;; define cons procedure using a data to judgge which one should be return
(define (cons-ug x y)
  (lambda (m)
    (if (= m 1) x
      y)))
(define (car-ug f) (f 1))
(define (cdr-ug f) (f 2))

(define data-ug (cons-ug 5 7))
(display (car-ug data-ug))
(newline)
(display (cdr-ug data-ug))
(newline)


;; a better way is to return a high order function which is invoked by other procedures
(define (cons x y)
  (lambda (f)
    (f x y)))
(define (car f)
  (f (lambda (x y) x)))
(define (cdr f)
  (f (lambda (x y) y)))

(define data (cons 5 7))
(display (car data))
(newline)
(display (cdr data))
(newline)

