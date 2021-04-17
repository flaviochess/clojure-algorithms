(ns chapter1.binary-search-algorithm)

(defn get-middle
  "get middle between two numbers and round up when it's a fraction"
  [low high]
  (int (Math/ceil (/ (+ low high) 2))))

(defn binary-search
  "search a number position in a ordered list/array"
  [list, item]

  (loop [low 0
         high (- (count list) 1)]
    (if (> low high)
      nil
      (let [mid (get-middle low high)
            guess (get list mid)]
        (if (= guess item)
          mid
          (if (> guess item)
            (recur low (- mid 1))
            (recur (+ mid 1) high)))))))

;tests
(def my-list [1, 3, 5, 7, 9])
(println (binary-search my-list 3)) ;position result = 1
(println (binary-search my-list 9)) ;position result = 4
(println (binary-search my-list 2)) ;position result = nil
(println (binary-search my-list 7)) ;position result = 3
