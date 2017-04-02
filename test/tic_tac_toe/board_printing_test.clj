(ns tic-tac-toe.board-printing-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board-printing :refer :all]
[tic-tac-toe.board :refer :all]))

(deftest format-board-for-printing
  (is (= "123\n456\n789" (format-board (create-board)))))

(deftest print-board-to-out
  (is (= "123\n456\n789\n" (with-out-str (print-board (format-board (create-board)))))))

(deftest print-board-with-markers
  (is (="12X\n456\n789\n" (with-out-str (print-board (format-board (place-marker :2 "X" (create-board))))))))

