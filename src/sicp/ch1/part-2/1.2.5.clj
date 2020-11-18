(defn gcd [a b]
  (cond
    (= b 0) a
    :else (gcd b (rem a b))))

(gcd 206, 40)
