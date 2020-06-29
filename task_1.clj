(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5))))) (* 3 (- 6 2) (- 2 7)))



(defn squareInMax [a b c] 
    (cond
        (and (> a c) (> b c)) (+ (* b b) (* a a))
        (and (> a b) (> c b)) (+ (* c c) (* a a))
        (and (> c a) (> b a)) (+ (* b b) (* c c))
    ))

(squareInMax 3 2 5)



(Math/pow 3 2)
