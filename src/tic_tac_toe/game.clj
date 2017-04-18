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
   (print-board (format-board board)) board))

(defn print-and-format [board]
  (print-board (format-board board)) board)

(defn space-already-selected [board marker]
  (println "Space already selected.")
  (place-human-marker board marker))

(defn place-human-marker [board marker]
(let [selection (keyword (get-human-selection))]
   (cond (= "O" (get board selection)) (space-already-selected board marker)
         :else (place-marker selection  marker board ))))

(defn computer-turn  [board marker]
  (print-and-format  (place-marker  (minimax board marker ) marker board )))

(defn human-turn [board marker]
  (print-and-format (place-human-marker board marker)))

(defn game-loop [board marker]
  (let [marked-board (human-turn board marker)]
   (cond (or (is-tie? marked-board) (is-win? marked-board)) (println "Game Over.")
         :else (game-loop marked-board (switch-marker marker)))))

(defn game-loop-human-computer  [board marker]
  (cond  (is-tie? board)  (println "Game Over - Tie.")
         (is-win? board)  (println "Game Over - Computer Wins.")
         :else
  (let  [marked-board  (human-turn board "X")]
   (cond (is-win? marked-board)  (println "Game Over - Huamn Wins.")
         (is-tie? marked-board)  (println "Game Over - Tie.")
         :else  (do  (game-loop-human-computer  (computer-turn marked-board "O") "O" ))))))
