(ns tic-tac-toe.game
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]
          [tic-tac-toe.human-ui :refer :all] ))

(defn start [] (let [board (create-board)] (print-board (format-board board)) board ))

(defn print-and-format [board]
(print-board (format-board board)) board
)

(defn place-human-marker [board marker]
     (place-marker (keyword (get-human-selection))  marker board ))

(defn human-turn [board marker]
(print-and-format (place-human-marker board marker))
)

(defn game-loop [board]
(human-turn (human-turn board "X") "O" )
)
