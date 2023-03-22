;; normal version without optimization
;; uses more memory
(define (fact n)
  (if (= n 1)
    1
    (* n (fact (- n 1)))))

(display (fact 4))
(newline)
    
;; iterable version with tail recursion
;; uses less memory than above version
(define (fact n)
    (define (fact-iter n res)
      (if (= n 1)
        res
        (fact-iter (- n 1) (* res n))))
    (fact-iter n 1))

(display (fact 4))
(newline)
