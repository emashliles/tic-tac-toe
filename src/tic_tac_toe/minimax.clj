(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.minimax-scoring :refer :all]))


(defn minimax [board current-player]


  (let [score (calculate-score current-player board) ]
   (cond (not (nil? score)) score
        (nil? score) nil)


))
