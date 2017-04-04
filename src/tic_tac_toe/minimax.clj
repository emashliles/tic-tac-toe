(ns tic-tac-toe.minimax 
  (:require [tic-tac-toe.minimax-scoring :refer :all]
            [tic-tac-toe.board :refer :all]))

(defn switch-marker-mm [marker] 
  (if (= marker "X")
   "O"
   "X" ))

(defn find-min-score [scores current-highscore current-high-score-value]
    (if (empty? scores) current-highscore
      (let [score  (first (vals (doall (take 1 scores)))) ]
      (let [score-key  (first (keys (doall (take 1 scores )))) ]
         (cond (< score current-high-score-value) (find-min-score (into {}  (rest scores)) (assoc {} score-key score) score) 
               :else (find-min-score  (into {}  (rest scores))current-highscore current-high-score-value)
)))))


(defn find-max-score [scores current-highscore current-high-score-value]
    (if (empty? scores) current-highscore
      (let [score  (first (vals (doall (take 1 scores)))) ]
      (let [score-key  (first (keys (doall (take 1 scores )))) ]
         (cond (> score current-high-score-value) (find-max-score (into {} (rest scores)) (assoc {} score-key score) score) 
               :else (find-max-score  (into {} (rest scores))current-highscore current-high-score-value)
)))))

(defn best-score [scores player]
(cond (= player "O") (do (into {} (find-max-score (into {} scores) {} -200 )))
      (= player "X") (do (into {} (find-min-score (into {} scores) {} 200)))))

(defn minimax-body [board current-player move]
  (let [score (calculate-score current-player board) ]
   (cond (not (nil? score)) (zipmap [move] [score] )
         (nil? score) 
         (do (let [next-player (switch-marker-mm current-player)]
             (let [moves (available-spaces board)]
              (do (best-score (map #(minimax-body (place-marker % next-player board) next-player % ) moves) next-player))))))))

(defn minimax [board current-player]
  (let [moves (available-spaces board)]
  (let [scores (into {} (map #(minimax-body (place-marker % current-player board) current-player %) moves))] 
    (println board)
    (println scores)
    (first (keys (doall (take 1 (find-max-score (into {} scores) {} -200)))))

)))     

