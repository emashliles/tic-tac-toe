(ns tic-tac-toe.game
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]
          [tic-tac-toe.human-ui :refer :all] ))

(defn start [] (print-board (format-board (create-board))))

(defn print-and-format [board]
(print-board (format-board board)))

(defn place-human-marker [board]
     (place-marker (keyword (get-human-selection))  "X" board ))

(defn human-turn [board]
(print-and-format (place-human-marker board))
)
