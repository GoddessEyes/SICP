; Simple factorial realization:
(defn factorial [val] 
    (if (<= val 1)
        1
        (* val (factorial (- val 1)))
    )
)

(factorial 4)


