
; Tasks 1.3.2:

(defn sum [term a next b]
  (cond (> a b) 0
        :else (+ (term a)
                 (sum term (next a) next b))))

(defn sum-int-1 [a b]
  (cond
    (> a b) 0
    :else (+ a (sum-int-1 (inc a) b))))

(sum-int-1 10 1)
(sum-int-1 1 10)

(defn cube [a]
  (* a a a))

(defn sum-cubes-1 [a b]
  (cond
    (> a b) 0
    :else (+ (cube a) (sum-cubes-1 (inc a) b))))

(sum-cubes-1 3 5)

(defn sum-base [term a next b]
  (cond
    (> a b) 0
    :else (+ (term a)
             (sum term (next a) next b))))

(defn identity [n] n)

(defn sum-int-2 [a b]
  (sum-base identity a inc b))

(sum-int-2 2 4)

(defn sum-int [term a next b]
  (loop [a a
         acc 0]
    (if (> a b) acc
        (recur (next a) (+ acc (term a))))))

; Tasks 1.3.2:

(defn intergral [f a b dx]
  (* (sum f
          (+ a (/ dx 2.0))
          b)
     dx))

; (2 2) call
(defn test-fun [func] ((func 2)))

(def tolerance 0.000001)

(defn fixed-point [f first-guess]
  (letfn [(close-enough? [v1 v2]
            (< (Math/abs (- v1 v2)) tolerance))
          (try-it [guess]
            (let [next (f guess)]
              (if (close-enough? guess next)
                next
                (try-it next))))]
    (try-it first-guess)))

(defn sin [x] (Math/sin x))

(fixed-point sin 1)


; deriv:

(def dx 0.00001)
(defn deriv [g]
  (fn [x]
    (/ (- (g (+ x dx)) (g x)) dx)))

(defn newton-transform [g]
  (fn [x]
    (- x (/ (g x) ((deriv g) x)))))

(defn newtons-method [g guess]
  (fixed-point (newton-transform g) guess))



