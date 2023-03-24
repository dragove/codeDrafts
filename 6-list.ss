#lang scheme

(require "common.ss")

;; python range like procedure
(define (range from to)
  (if (> from to) nil
    (cons from (range (+ from 1) to))))

(define data (range 1 5))
(display data)
(newline)

(define (list-ref lst n)
  (if (= n 0) (car lst)
    (list-ref (cdr lst) (- n 1))))

(display (list-ref data 2))
(newline)

(define (length lst)
  (if (null? lst)
    0
   (+ 1 (length (cdr lst)))))
    
(display (length data))
(newline)

(define (append list1 list2)
  (if (null? list1)
    list2
    (cons (car list1) (append (cdr list1) list2))))

(display (append data data))
(newline)

