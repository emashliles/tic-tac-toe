(ns tic-tac-toe.game
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]
          [tic-tac-toe.human-ui :refer :all]
          [tic-tac-toe.board-evaluation :refer :all]
          [tic-tac-toe.minimax :refer :all]
          [tic-tac-toe.markers :refer :all]))

(defn start-game [] 
  (let [board (create-board)] 
   (print-and-format board) board))

(defn place-human-marker [board marker]
(let [selection (keyword (get-human-selection))]
   (cond 
     (not= (empty-space) (get board selection)) (do (invalid-selection "Space already selected.")
                                                    (place-human-marker board marker))
     :else (place-marker selection marker board))))

(defn computer-turn [board marker]
  (print-and-format (place-marker (minimax board marker) marker board)))

(defn human-turn [board marker]
  (print-and-format (place-human-marker board marker)))

(defn game-loop [board marker]
  (cond 
    (is-tie? board) (game-over "Tie.")
    (is-win? board) (game-over "Computer Wins.")
    :else
  (let [marked-board (human-turn board (human-marker))]
   (cond 
     (is-win? marked-board) (game-over "Huaman Wins.")
     (is-tie? marked-board) (game-over "Tie.")
     :else  (do (game-loop (computer-turn marked-board (computer-marker)) (computer-marker)))))))

