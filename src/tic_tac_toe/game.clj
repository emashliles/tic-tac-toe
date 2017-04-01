(ns tic-tac-toe.game
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]
          [tic-tac-toe.human-ui :refer :all]
          [tic-tac-toe.board-evaluation :refer :all]))

(defn switch-marker [marker] (if (= marker "X")"O""X" ))

(defn start [] (let [board (create-board)] (print-board (format-board board)) board ))

(defn print-and-format [board]
(print-board (format-board board)) board
)

(defn place-human-marker [board marker]
     (place-marker (keyword (get-human-selection))  marker board ))

(defn human-turn [board marker]
(print-and-format (place-human-marker board marker))
)


(defn game-loop [board marker]
(let [marked-board (human-turn board marker)]
(cond (or (is-tie? marked-board) (is-win? marked-board)) (println "Game Over.")
      :else (game-loop marked-board (switch-marker marker) )
)))

