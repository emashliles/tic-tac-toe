(ns tic-tac-toe.minimax-scoring-test 
  (:require [clojure.test :refer :all]
            [tic-tac-toe.minimax-scoring :refer :all]))

(deftest score-winning-max-player-10 (is (= 10 (calculate-score "O" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "O", :8 "O") ))))

(deftest score-winning-min-player-minus-10 (is (= -10 (calculate-score "X" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "X", :5 "X", :6 "O", :7 "X", :8 "O")))))

(deftest score-tie-0 (is (= 0 (calculate-score "O" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "X", :7 "O", :8 "X")))))

(deftest score-nil-if-no-end-condition (is (= nil (calculate-score "O" (sorted-map :0 "O", :1 "X", :2 "O", :3 "", :4 "O", :5 "X", :6 "X", :7 "O", :8 "X")))))
