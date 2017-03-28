(ns tic-tac-toe.board-printing-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board-printing :refer :all]
[tic-tac-toe.board :refer :all]
))

(deftest format-board-for-printing
 (is (= "123\n456\n789" (format-board (create-board)))))

