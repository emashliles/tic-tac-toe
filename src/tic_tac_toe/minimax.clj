(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.minimax-scoring :refer :all]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.game :refer :all]))

(defn best-score [scores player]
(cond (= player "O") (do (into  {}  (into {} (max scores))))
      (= player "X") (do (into  {}  (into {} (min scores))))))

(defn minimax-body [board current-player move]
  (let [score (calculate-score current-player board) ]
   (cond (not (nil? score)) (assoc {} move score)
         (nil? score) 
         (do (let [next-player (switch-marker current-player)]
             (let [moves (available-spaces board)]
                 (do (best-score  (map #(minimax-body (place-marker % next-player board) next-player % ) moves) next-player) ) ))))))

(defn minimax [board current-player]
  (let [moves (available-spaces board)]
  (let [scores (into {} (map #(minimax-body (place-marker % "O" board) "O" %) moves))] 
  (best-score scores "O")
)))     



 ;(first (max-key val (map #( assoc {} % (minimax-body (place-marker % "O" board) "O" %)) moves))) ))

; (first (max-key val (map #(minimax-body (place-marker % "O" board) "O" %) moves))))) 

; (into {} (map #(minimax-body (place-marker % "O" board) "O" %) moves))))   


;(defn minimax-body [board current-player move]
;  (let [score (calculate-score current-player board) ]
;   (cond (not (nil? score)) (assoc {} move score)
;         (nil? score) 
;         (do (let [next-player (switch-marker current-player)]
;             (let [moves (available-spaces board)]
;                  (cond (= next-player "O") (do (best-score  (map #(minimax-body (place-marker % "O" board) "O" % ) moves) "O" ) )
;                        (= next-player "X") (do (best-score  (map #(minimax-body (place-marker % "X" board) "X" % ) moves) "X" ) )
;
;)))))))
