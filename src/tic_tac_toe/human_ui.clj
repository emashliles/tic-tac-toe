(ns tic-tac-toe.human-ui)

(defn is-valid? [selection]
  (contains? #{"1" "2" "3" "4" "5" "6" "7" "8" "9"} selection ))

(defn get-human-selection []
  (let [selection (read-line)]
   (cond (= true (is-valid? selection)) (str (- (read-string selection) 1 ))
         (= false (is-valid? selection)) (do (get-human-selection)))))

