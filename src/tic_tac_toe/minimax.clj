(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.board :refer :all]
            [tic-tac-toe.board-evaluation :refer :all]))

(declare minimax-body)
(declare switch-marker-mm)
(declare best-score-vec)

(defn calculate-score [player board max-player min-player]
  (cond 
   (and (is-win? board) (= player max-player)) 10
   (and (is-win? board) (= player min-player)) -10
   (is-tie? board ) 0
   :else (best-score-vec (zipmap (available-spaces board)  (map #(calculate-score (switch-marker-mm player) (place-marker % (switch-marker-mm player) board)  max-player min-player) (available-spaces board))) player max-player min-player)))

(defn switch-marker-mm [marker] 
  (if (= marker "X")
   "O"
   "X" ))

(defn best-score-vec [scores player max-player min-player]
(cond (= player max-player) (val (apply max-key val scores))
      (= player min-player)  (val (apply min-key val scores)) ))

(defn best-score [scores player max-player min-player]
(cond (= player max-player)  (key (apply max-key val scores) )
      (= player min-player) (key (apply min-key val scores) )))

(defn minimax-body [board current-player max-player min-player]
(let [scores (zipmap (map #(calculate-score current-player board max-player min-player) (available-spaces board)) (available-spaces board) ) ]
(best-score scores current-player  max-player min-player )))

(defn minimax [board current-player]
  (let [moves (available-spaces board)]
  (let [scores (zipmap moves  (map #(calculate-score current-player (place-marker % current-player board )  current-player (switch-marker-mm current-player)) moves) )] 
    (best-score scores current-player current-player (switch-marker-mm current-player)))))     

