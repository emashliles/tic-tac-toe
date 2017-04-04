(ns tic-tac-toe.main(:gen-class)
(:require [tic-tac-toe.game :refer :all]
          [tic-tac-toe.board :refer :all]))

(defn -main [] (game-loop-h-c (start) "X" ))

