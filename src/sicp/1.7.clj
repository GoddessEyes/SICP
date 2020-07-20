(defn sqrt [n]
  (letfn [(good-enough? [old-guess new-guess]
            (< (/ (Math/abs (- old-guess new-guess))
                  old-guess)
               0.001))
          (average [x y] (/ (+ x y) 2))
          (improve [guess]
            (average guess (/ n guess)))
          (help [guess]
            (let [new (improve guess)]
              (if (good-enough? guess new) new
                  (help new))))]
    (help 1.0)))

(sqrt -111)

(defn coube-root [y]
  (letfn [(coube-root-iter [guess y]
            (letfn [(cube [y]
                      (Math/pow y 3))
                    (good-enough? [guess y]
                      (< (Math/abs (- (cube guess) y)) 0.001))
                    (improve [guess y]
                      (/ (+ (/ y (* guess guess)) (* 2 guess)) 3))])
            (if (good-enough? guess y)
              guess
              (coube-root-iter (improve guess y) y)))] (coube-root-iter 1.0 y)))

(coube-root 9)
