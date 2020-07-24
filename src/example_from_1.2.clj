(defn first-denomination [kinds-of-coin]
  (cond
    (== kinds-of-coin 1) 1
    (== kinds-of-coin 2) 5
    (== kinds-of-coin 3) 10
    (== kinds-of-coin 4) 25
    :else 50))

(defn cc [amount kinds-of-coin]
  (cond
    (== amount 0) 1
    (or (< amount 0) (= kinds-of-coin 0)) 0
    :else (+
           (cc amount (- kinds-of-coin 1))
           (cc (- amount (first-denomination kinds-of-coin)) kinds-of-coin))))

(defn count-change [amount]
  (cc amount 5))

(count-change 100)


; (defn fib [n]
;   (fib-iter 1, 0, n))

; (defn fib-iter [a b count]
;   (if (= count 0)
;     b
;     (fib-iter (+ a b) a (- count 1))))

; (fib 4)
