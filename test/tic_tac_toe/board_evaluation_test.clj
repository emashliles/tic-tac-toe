(ns tic-tac-toe.board-evaluation-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.board-evaluation :refer :all]))

(deftest identifies-tie (is (is-tie?  (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "X", :8 "O")  ) ))

(deftest identifies-non-tie (is (not (is-tie? (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "", :8 "O")))))

(deftest one-move-is-non-tie (is (not (is-tie? (sorted-map :0 "", :1 "X", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 "")))))

(deftest identifies-winning-row  (is  (is-win?  (sorted-map :0 "O", :1 "X", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "O", :8 "O"))))

(deftest identifies-empty-row  (is not (is-win? (sorted-map :0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 ""))))

(deftest detects-win-row (is (get-row-sets (partition 3 (vals (sorted-map :0 "O", :1 "O", :2 "O", :3 "X", :4 "O", :5 "X", :6 "O", :7 "X", :8 "O"))))))

(deftest identifies-winning-column  (is  (is-win? (sorted-map :0 "X", :1 "", :2 "", :3 "X", :4 "", :5 "", :6 "X", :7 "", :8 ""))))
