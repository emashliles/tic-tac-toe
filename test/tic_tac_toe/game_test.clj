(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]
            [tic-tac-toe.board :refer :all]))

(deftest start-game-returns-board (is 
  (with-out-str (= {:0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 ""}  (start-game)))))

(deftest make-human-move (is 
  (.contains (with-out-str (with-in-str "2" (human-turn (create-board) "X" ))) "| 1 || X || 3 |\n" )))

(deftest end-game-at-tie (is 
  (.contains (with-out-str (with-in-str "8" (game-loop  (sorted-map :0 "X", :1 "O", :2 "X", :3 "X", :4 "O", :5 "X", :6 "O", :7 "", :8 "O") "X"))) "Game Over" )))

(deftest space-already-selected-is-invalid (is 
  (.contains (with-out-str (with-in-str "7\n8\n" (game-loop  (sorted-map :0 "X", :1 "O", :2 "X", :3 "X", :4 "O", :5 "X", :6 "O", :7 "", :8 "O") "X"))) "Space already selected.")))
