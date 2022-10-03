;; f(x) = x^3 -> f'(x) = 3*x^2
(define (f x) (* x x x))

;; (number -> number) -> (number -> number)
(define (deriv f)
  (lambda (x) (/ (- (f (+ x epsilon))
                    (f x))
                 epsilon)))
  
(define m (deriv f))

(define epsilon 0.00001)

;; should be 3 * 2^2 = 12
(display (m 2))
(newline)


