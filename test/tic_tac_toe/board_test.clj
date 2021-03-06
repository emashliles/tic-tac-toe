(ns tic-tac-toe.board-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board :refer :all]))

(deftest empty-board-created
  (is (= {:0 "" :1 "" :2 "" :3 "" :4 "" :5 "" :6 "" :7 "" :8 ""} (create-board))))

(deftest place-marker-on-board
  (is (= {:0 "" :1 "" :2 "X" :3 "" :4 "" :5 "" :6 "" :7 "" :8 ""} (place-marker :2 "X" (create-board) ))))

(deftest return-available-spaces (is (= [:0 :5 :6] (available-spaces  (sorted-map :0 "", :1 "X", :2 "X", :3 "O", :4 "X", :5 "", :6 "", :7 "X", :8 "O")) )))

