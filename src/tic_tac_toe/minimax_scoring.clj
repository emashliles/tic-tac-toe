(ns tic-tac-toe.minimax-scoring
  (:require [tic-tac-toe.board-evaluation :refer :all])
)

(defn calculate-score [player board]
  (cond 
   (and (is-win? board) (= "O" player )) 10
   (and (is-win? board) (= "X" player )) -10
   (is-tie? board ) 0
   :else nil))
