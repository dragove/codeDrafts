(load "common.scm")
(define (make-rat x y) (cons x y))
(define (numer r) (car r))
(define (denom r) (cdr r))
(define (print-rat r)
  (display (numer r))
  (display "/")
  (display (denom r)))

(print-rat (make-rat 2 3))
(newline)

; +rat: Rat, Rat -> Rat
(define (+rat x y)
  (make-rat (+ (* (numer x) (denom y))
               (* (numer y) (denom x)))
            (* (denom x) (denom y))))

;; calculate 2/3 + 4/5
;; answer should be 5/4
(print-rat (+rat (make-rat 1 2) (make-rat 3 4)))
(newline)

; *rat: Rat, Rat -> Rat
(define (*rat x y)
  (make-rat (* (numer x) (numer y))
            (* (denom x) (denom y))))

(print-rat (*rat (make-rat 1 2) (make-rat 3 4)))
(newline)


;; simplify rational number in selector
(define (numer r) 
  (let ((g (gcd (car r) (cdr r))))
    (/ (car r) g)))
(define (denom r) 
  (let ((g (gcd (car r) (cdr r))))
    (/ (cdr r) g)))

(print-rat (+rat (make-rat 1 2) (make-rat 3 4)))
(newline)

;; simplify rational number in construction
(define (make-rat x y)
  (let ((g (gcd x y))
        (cons (/ x g)
              (/ y g)))))
;; roll back selector to default one
(define (numer r) (car r))
(define (denom r) (cdr r))

(print-rat (+rat (make-rat 1 2) (make-rat 3 4)))

(newline)
