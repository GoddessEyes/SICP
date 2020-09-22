; Линейно рекурсивный процес вычисления степени:

(defn pow  [number power]
  (cond
    (= power 0) 1
    :else (* number (pow number (- power 1)))))

(pow 3 2)


; Итеративный процес вычисления степени:


(defn pow-iter [b n]
  (letfn [(iter-pow [b counter prod]
            (cond
              (= counter 1) prod
              :else (iter-pow b (dec counter) (* prod b))))]
    (iter-pow b n 1)))

(pow-iter 3 3)


; Сокращение кол-ва шагов по степеням двойки:


(defn square [n] (* n n))

(defn fast-expt [b n]
  (cond
    (= n 0) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (- n 1)))))

(fast-expt 3 3)


; 1.16 Итеративный процесс с скоращением кол-ва шагов по степени двойки:

(defn fast-expt-iter [b n]
  (letfn [(iter [a b n]
            (cond
              (= n 0) a
              (even? n) (iter a (square b) (/ n 2))
              :else (iter (* a b) b (- n 1))))]
    (iter 1 b n)))

(fast-expt-iter 3 3)