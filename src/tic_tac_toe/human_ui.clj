(ns tic-tac-toe.human-ui)

(defn print-game-over-message [message]
  (println (str "Game Over - " message )))

(defn print-invalid-selection-message [message]
  (println (str "Invalid selection. " message)))

(defn- is-valid? [selection]
  (contains? #{"1" "2" "3" "4" "5" "6" "7" "8" "9"} selection ))

(defn get-human-selection []
  (let [selection (read-line)]
   (cond 
     (= true (is-valid? selection)) (str (- (read-string selection) 1 ))
     (= false (is-valid? selection)) (do (print-invalid-selection-message "Please enter a number between 1 and 9") (get-human-selection)))))

