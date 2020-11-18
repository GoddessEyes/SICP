; Recursive:
(defn factorial [val]
  (if (<= val 1)
    1
    (* val (factorial (- val 1)))))

(factorial 4)

; Iterative:
(defn factorial2 [val]
  (defn iter [product counter]
    (if (> counter val)
      product
      (iter (* counter product) (+ counter 1))))
  (iter 1 1))

(factorial2 4)

; Task 1.9 1.10:
; 1.9 -> Процесс рекурсивный т.к. порождает отложенные вычисления инфа о которых хранится в callstack
; 1.10 -> Процесс итеративный т.к. описывается конечным числом переменных состояния и не хранит результат прошлых вычислений. 