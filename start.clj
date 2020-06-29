; 1.1.2
(def pi 3.14159)
(def radius 10)
(* pi (* radius radius))

(def circumference (* 2 pi radius ))
circumference

; 1.1.4
(defn square [x] (* x x))
(square (square 3))

(defn sum-of-square [x y] 
    ( + (square x) (square y))
    )
(sum-of-square 3 4)

; 1.1.5
(defn f [a] (sum-of-square (+ a 1) (* a 2)))

; Applicative-order eval:
(f 3) ; == sum-of-square (+ 3 1) (* 3 2) == (sum-of-square 4 6) == 52

; Normal-order eval:
; (f 3) ; == (+ square(+ 3 1) square(* 3 2) == etc...

; 1.1.6 cond:
(defn abs [x]
    (cond 
        (> x 0) (x)
        (= x 0) (0)
        (< x 0) (- x)
        ))
(abs -1)

; Else cond:
(defn absElse [x] 
    (cond 
        (> x 0) x
        :else (- x)
        ))
(absElse -2)

; If condition:
(defn absIf [x]
    (if
        (> x 0) x (- x)
        ))

(absIf -2)

(def a 3)
