;; normal version without optimization
;; uses more memory
(define (factorial n)
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(display (factorial 4))
(newline)
    
;; iterable version with tail recursion
;; uses less memory than above version
(define (factorial n)
    (define (factorial-iter n res)
      (if (= n 1)
        res
        (factorial-iter (- n 1) (* res n))))
    (factorial-iter n 1))

(display (factorial 4))
(newline)
