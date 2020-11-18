
(defn squre [x]
  (* x x))

(defn divides? [a b]
  (= (rem b a) 0))

(defn find-divisor [n test-divisor]
  (cond
    (> (squre test-divisor) n) n
    (divides? test-divisor n) test-divisor
    :else (find-divisor n (+ test-divisor 1))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(prime? 561)


; Степень числа по модулю:


(defn expmod [base exp m]
  (cond
    (= exp 0) 1
    (even? exp) (rem (squre (expmod base (/ exp 2) m)) m)
    :else (rem (* base (expmod base (- exp 1) m)) m)))

(defn fermat-test [n]
  (letfn [(try-it [a]
            (= (expmod a n n) a))]
    (try-it (+ 1 (rand-int (- n 1))))))

(defn fast-prime? [n times]
  (cond
    (= times 0) true
    (fermat-test n) (fast-prime? n (- times 1))
    :else false))

; 561 Число Кармайкла дающее не верный результат :
(fast-prime?  561 1000) ; -> true
(prime? 561) ; -> false
