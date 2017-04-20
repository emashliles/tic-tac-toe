(ns tic-tac-toe.human-ui)

(defn- print-message [message]
  (println message))

(defn game-over-message [message]
  (print-message (str "Game Over - " message )))

(defn invalid-selection-message [message]
  (print-message (str "Invalid selection. " message)))

(defn- is-valid? [selection]
  (contains? #{"1" "2" "3" "4" "5" "6" "7" "8" "9"} selection ))

(defn get-human-selection []
  (let [selection (read-line)]
   (cond 
     (= true (is-valid? selection)) (str (- (read-string selection) 1 ))
     (= false (is-valid? selection)) (do (invalid-selection-message "Please enter a number between 1 and 9") (get-human-selection)))))

