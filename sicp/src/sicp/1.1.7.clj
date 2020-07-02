;
(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [guess x]
  (< (Math/abs (- (* guess guess) x)) 0.001))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt -111)



; Fibonacci memoize:


(def fib
  (memoize
   (fn [n]
     (cond
       (== 0 n) 1N
       (== 1 n) 1N
       :else (+ (fib (- n 1)) (fib (- n 2)))))))

(fib 100)

(defn iter-fib' [n a b]
  (if (== 0 n)
    a
    (recur (- n 1) b (+ a b))))

(iter-fib' 10000000 1N 1N)
