#lang scheme

(define (f n m)
  (cond ((= n 1) 1)
        ((= m 1) 1)
        (else (+ (f n (- m 1))
               (f (- n 1) m)))))

(display (f 4 4))
(newline)
