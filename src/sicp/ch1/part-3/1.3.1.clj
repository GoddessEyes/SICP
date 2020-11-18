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


