(ns chapter4.quicksort)

(defn quicksort
  [list]

  (if (< (count list) 2)
    list
    (do
      (let [pivot (nth list 0)
            less (filter #(<= % pivot) (rest list))
            greater (filter #(> % pivot) (rest list))]

        (concat (quicksort less) [pivot] (quicksort greater))))))

;tests
(println (quicksort [])) ; => []
(println (quicksort [15])) ; => [15]
(println (quicksort [15 9])) ; => (9 15)
(println (quicksort [15 9 7])) ; => (7 9 15)
(println (quicksort [15 9 7 10 3 4 20 30])) ; => (3 4 7 9 10 15 20 30)
(println (quicksort [15 30 9 7 10 3 4 20 4 30])) ; => (3 4 4 7 9 10 15 20 30 30)
