(ns tic-tac-toe.game
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]
          [tic-tac-toe.human-ui :refer :all]
          [tic-tac-toe.board-evaluation :refer :all]
          [tic-tac-toe.minimax :refer :all]))

(declare place-human-marker)

(defn switch-marker [marker] 
  (if (= marker "X")
   "O"
   "X" ))

(defn start [] 
  (let [board (create-board)] 
   (print-and-format board) board))

(defn space-already-selected [board marker]
  (println "Space already selected.")
  (place-human-marker board marker))

(defn place-human-marker [board marker]
(let [selection (keyword (get-human-selection))]
   (cond 
     (= "O" (get board selection)) (space-already-selected board marker)
     :else (place-marker selection marker board))))

(defn computer-turn [board marker]
  (print-and-format (place-marker (minimax board marker) marker board)))

(defn human-turn [board marker]
  (print-and-format (place-human-marker board marker)))

(defn game-loop  [board marker]
  (cond 
    (is-tie? board) (println "Game Over - Tie.")
    (is-win? board) (println "Game Over - Computer Wins.")
    :else
  (let  [marked-board  (human-turn board "X")]
   (cond 
     (is-win? marked-board) (println "Game Over - Huamn Wins.")
     (is-tie? marked-board) (println "Game Over - Tie.")
     :else  (do (game-loop (computer-turn marked-board "O") "O"))))))
