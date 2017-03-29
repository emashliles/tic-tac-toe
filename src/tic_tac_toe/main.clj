(ns tic-tac-toe.main(:gen-class)
(:require [tic-tac-toe.board :refer :all] 
          [tic-tac-toe.board-printing :refer :all]) )

(defn -main [] (print-board (format-board (create-board))))
