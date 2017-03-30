(ns tic-tac-toe.board-evaluation-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board-evaluation :refer :all]))

(deftest identifies-tie (is (is-tie?  {:0 "O" :1 "X" :2 "O" :3 "X" :4 "O" :5 "X" :6 "O" :7 "X" :8 "O"}  ) ))

(deftest identifies-non-tie (is (not (is-tie?  {:0 "" :1 "X" :2 "O" :3 "X" :4 "" :5 "X" :6 "O" :7 "X" :8 "O"}  )) ))
