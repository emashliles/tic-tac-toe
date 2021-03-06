(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]
            [tic-tac-toe.board :refer :all]))

(deftest start-game (is (= "\u001b[2J\u001B[0;0f| 1 || 2 || 3 |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |\n" (with-out-str (start)))))

(deftest start-game-returns-board (is 
  (= {:0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 ""}  (start))))

(deftest make-human-move (is 
  (= "\u001b[2J\u001B[0;0f| 1 || X || 3 |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |\n" (with-out-str (with-in-str "2" (human-turn (create-board) "X" )) ))) )

(deftest prints-and-formats (is 
  (= "\u001b[2J\u001B[0;0f| 1 || 2 || 3 |\n---------------\n| 4 || 5 || 6 |\n---------------\n| 7 || 8 || 9 |\n" (with-out-str (print-and-format (create-board))))))

(deftest end-game-at-tie (is 
  (= "\u001b[2J\u001B[0;0f| X || O || X |\n---------------\n| X || O || X |\n---------------\n| O || X || O |\nGame Over.\n" (with-out-str (with-in-str "8" (game-loop  (sorted-map :0 "X", :1 "O", :2 "X", :3 "X", :4 "O", :5 "X", :6 "O", :7 "", :8 "O") "X"))))))

(deftest switch-O-to-X (is (= "X" (switch-marker "O"))))

(deftest switch-X-to-O (is (= "O" (switch-marker "X"))))

(deftest space-already-selected-is-invalid (is 
  (= "Space already selected.\n\u001b[2J\u001B[0;0f| X || O || X |\n---------------\n| X || O || X |\n---------------\n| O || X || O |\nGame Over.\n" (with-out-str (with-in-str "7\n8\n" (game-loop  (sorted-map :0 "X", :1 "O", :2 "X", :3 "X", :4 "O", :5 "X", :6 "O", :7 "", :8 "O") "X"))))))
