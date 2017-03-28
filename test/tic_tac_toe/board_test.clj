(ns tic-tac-toe.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board :refer :all]))

(deftest empty-board-created
 (is (= {:0 "" :1 "" :2 "" :3 "" :4 "" :5 "" :6 "" :7 "" :8 ""} (create-board))))

