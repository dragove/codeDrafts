#lang scheme

(require "common.ss")

(define (make-rat-1 x y) (cons x y))
(define (numer-1 r) (car r))
(define (denom-1 r) (cdr r))
(define (print-rat r)
  (display (numer-1 r))
  (display "/")
  (display (denom-1 r)))

(print-rat (make-rat-1 2 3))
(newline)

; +rat: Rat, Rat -> Rat
(define (+rat x y)
  (make-rat-1 (+ (* (numer-1 x) (denom-1 y))
                 (* (numer-1 y) (denom-1 x)))
            (* (denom-1 x) (denom-1 y))))

;; calculate 2/3 + 4/5
;; answer should be 5/4
(print-rat (+rat (make-rat-1 1 2) (make-rat-1 3 4)))
(newline)

; *rat: Rat, Rat -> Rat
(define (*rat-1 x y)
  (make-rat-1 (* (numer-1 x) (numer-1 y))
            (* (denom-1 x) (denom-1 y))))

(print-rat (*rat-1 (make-rat-1 1 2) (make-rat-1 3 4)))
(newline)


;; simplify rational number in selector
(define (numer-2 r)
  (let ((g (gcd (car r) (cdr r))))
    (/ (car r) g)))
(define (denom-2 r)
  (let ((g (gcd (car r) (cdr r))))
    (/ (cdr r) g)))

(print-rat (+rat (make-rat-1 1 2) (make-rat-1 3 4)))
(newline)

;; simplify rational number in construction
(define (make-rat x y)
  (let ([g (gcd x y)])
       (cons (/ x g)
             (/ y g))))
;; roll back selector to default one
(define (numer r) (car r))
(define (denom r) (cdr r))

(print-rat (+rat (make-rat 1 2) (make-rat 3 4)))

(newline)
