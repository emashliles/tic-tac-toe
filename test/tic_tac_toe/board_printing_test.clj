(ns tic-tac-toe.board-printing-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board-printing :refer :all]
[tic-tac-toe.board :refer :all]))

(deftest format-board-for-printing
  (is (= "| 1 || 2 || 3 |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |" (format-board (create-board)))))

(deftest print-board-to-out
  (is (= "\u001b[2J\u001B[0;0f| 1 || 2 || 3 |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |\n" (with-out-str (print-board (format-board (create-board)))))))

(deftest print-board-with-markers
  (is (="\u001b[2J\u001B[0;0f| 1 || 2 || X |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |\n" (with-out-str (print-board (format-board (place-marker :2 "X" (create-board))))))))

