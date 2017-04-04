(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.minimax-scoring :refer :all]
            [tic-tac-toe.board :refer :all]))

(defn switch-marker-mm [marker] 
  (if (= marker "X")
   "O"
   "X" ))

(defn best-score [scores player]
(cond (= player "O") (do (into  {}  (into {} (max scores))))
      (= player "X") (do (into  {}  (into {} (min scores))))))

(defn minimax-body [board current-player move]
  (let [score (calculate-score current-player board) ]
   (cond (not (nil? score)) (zipmap [move] [score] )
         (nil? score) 
         (do (let [next-player (switch-marker-mm current-player)]
             (let [moves (available-spaces board)]
                 (do (best-score  (map #(minimax-body (place-marker % next-player board) next-player % ) moves) next-player) ) ))))))

(defn minimax [board current-player]
  (let [moves (available-spaces board)]
  (let [scores (into {} (map #(minimax-body (place-marker % "O" board) "O" %) moves))] 
    (first (keys (doall (take 1 (best-score scores "O"))))))))     

