;  Recursive:

(defn recur-func [n]
  (cond
    (< n 3) n
    :else (+
           (recur-func (- n 1))
           (recur-func (- n 2))
           (recur-func (- n 3)))))

(recur-func 4)

; Iterative:

(defn iter-func [n]
  (letfn [(check-func [n1 n2 n3 counter]
            (if (= counter n) (+ n1 n2 n3)
                (check-func n2 n3 (+ n1 n2 n3) (inc counter))))]

    (if (< n 3) n
        (check-func 0 1 2 3))))

(iter-func 4)

; Pascal:

(defn pascal [row col]
  (cond (= row 0) (if (= col 0) 1 (throw (Exception. "Out of range")))
        (= col 0) 1
        (= col row) 1
        (> row 1) (if (or (< col 0) (> col row))
                    (throw (Exception. "Out of range"))
                    (+ (pascal (dec row) (dec col))
                       (pascal (dec row) col)))
        :else (throw (Exception. "Out of range"))))

(for [row (range 0 10)
      col (range 0 (inc row))]
  (pascal row col))
