(ns tic-tac-toe.main(:gen-class)
(:require [tic-tac-toe.game :refer :all]
          [tic-tac-toe.board :refer :all]
          [tic-tac-toe.markers :refer :all]))

(defn -main [] (game-loop (start-game) (human-marker)))

