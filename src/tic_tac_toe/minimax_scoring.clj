(ns tic-tac-toe.minimax-scoring
  (:require [tic-tac-toe.board-evaluation :refer :all]))

(defn calculate-score [player board depth max-player min-player]
  (cond 
   (and (is-win? board) (= player max-player)) (- 10 depth )
   (and (is-win? board) (= player min-player)) (- depth 10)
   (is-tie? board ) 0
   :else nil))
