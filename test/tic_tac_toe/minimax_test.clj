(ns tic-tac-toe.minimax-test 
  (:require [clojure.test :refer :all]
            [tic-tac-toe.minimax :refer :all]))

(deftest score-winning-max-player-10 (is (= 10 (calculate-score "O" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "O", :8 "O") "O" "X" ))))

(deftest score-winning-min-player-minus-10 (is (= -10 (calculate-score "X" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "X", :5 "X", :6 "O", :7 "X", :8 "O") "O" "X" ))))

(deftest score-tie-0 (is (= 0 (calculate-score "O" (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "X", :7 "O", :8 "X") "O" "X" ))))

(deftest make-only-available-move (is (= :7 (minimax (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "X", :7 "", :8 "X") "O"))))

(deftest take-winning-move (is (= :8 (minimax (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "", :7 "", :8 "") "O"))))

(deftest block-opponent-winning (is (= :2 (minimax (sorted-map :0 "", :1 "", :2 "", :3 "", :4 "", :5 "X", :6 "O", :7 "", :8 "X") "O"))))

(deftest block-opponent-winning-l-r-diagonal (is (= :8 (minimax (sorted-map :0 "X", :1 "O", :2 "O", :3 "", :4 "X", :5 "", :6 "", :7 "", :8 "") "O"))))

(deftest block-opponent-winning-r-l-diagonal (is (= :6 (minimax (sorted-map :0 "", :1 "O", :2 "X", :3 "", :4 "X", :5 "", :6 "", :7 "", :8 "") "O"))))

(deftest create-two-potential-winning-moves (is (= :8 (minimax (sorted-map :0 "", :1 "", :2 "", :3 "", :4 "X", :5 "", :6 "", :7 "", :8 "") "O"))))

(deftest select-corner-at-start (is (= :8 (minimax (sorted-map :0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 "") "O"))))

