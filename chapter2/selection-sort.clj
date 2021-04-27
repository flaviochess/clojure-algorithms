(ns chapter2.selection-sort)

(defn get-smallest
  "get a smallest number between two numbers"
  [value1 value2]
  (if (< value1 value2)
    value1
    value2))

(defn selection-sort
  "return a new list ordered based on the list passed"
  ([list]
   (selection-sort list []))

  ([unordered-list ordered-list]
    (if (seq unordered-list)
      (do
        (let [smallest (reduce get-smallest unordered-list)
              iterator-list (remove #{smallest} unordered-list)
              result-list (conj ordered-list smallest)]
          (recur iterator-list result-list)))
      ordered-list)))

;tests
(println (get-smallest 15 9)) ;result = 9
(println (reduce get-smallest [15 9 7 10 3 4 20 30])) ;result = 3
(println (selection-sort [15 9 7 10 3 4 20 30])) ;result = [3 4 7 9 10 15 20 30]
