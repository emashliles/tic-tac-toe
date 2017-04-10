(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.board-evaluation :refer :all]
            [tic-tac-toe.board :refer :all]))

(defn calculate-score [player board max-player min-player]
  (cond 
   (and (is-win? board) (= max-player player )) 10
   (and (is-win? board) (= min-player player )) -10
   (is-tie? board ) 0
   :else nil))

(defn switch-marker-mm [marker] 
  (if (= marker "X")
   "O"
   "X" ))

(defn best-score [scores player max-player min-player]
(cond (= player max-player) (do (into (sorted-map) (max scores)))
      (= player min-player) (do (into (sorted-map) (min scores)))))

(defn minimax-body [board current-player move max-player min-player]
  (let [score (calculate-score current-player board max-player min-player) ]
   (cond (not (nil? score)) (zipmap [move] [score] )
         (nil? score) 
         (do (let [next-player (switch-marker-mm current-player)]
             (let [moves (available-spaces board)]
                  (do (best-score  (map #(minimax-body (place-marker % next-player board) next-player % max-player min-player) moves) next-player max-player min-player) ) ))))))

(defn minimax [board current-player]
  (let [moves (available-spaces board)]
  (let [scores (into (sorted-map) (map #(minimax-body (place-marker % current-player board ) current-player %  current-player (switch-marker-mm current-player)) moves))] 
;  (println board)
 (println scores)
 ; (println moves)
  (first (keys (doall (take 1 (best-score scores current-player current-player (switch-marker-mm current-player)))))))))     

