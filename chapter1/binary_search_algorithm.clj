(ns chapter1.binary-search-algorithm)

(defn get-middle
  "get middle between two numbers and round up when it's a fraction"
  [low high]
  (int (Math/ceil (/ (+ low high) 2))))

(defn binary-search
  "search a number position in a ordered list/array"
  ([list, item]
   (binary-search list item 0 (- (count list) 1)))

  ([list item low high]
   (if (> low high)
     nil
     (let [mid (get-middle low high)
           guess (get list mid)]
       (if (= guess item)
         mid
         (if (> guess item)
           (recur list item low (- mid 1))
           (recur list item (+ mid 1) high)))))))

;tests
(def my-list [1, 3, 5, 7, 9])
(println (binary-search my-list 3)) ; => 1
(println (binary-search my-list 9)) ; => 4
(println (binary-search my-list 2)) ; => nil
(println (binary-search my-list 7)) ; => 3
