(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]
            [tic-tac-toe.board :refer :all]
))

(deftest start-game (is (= "123\n456\n789\n" (with-out-str (start)))))

(deftest start-game-returns-board (is (= {:0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 ""}  (start))))

(deftest make-human-move (is (= "1X3\n456\n789\n" (with-out-str (with-in-str "2" (human-turn (create-board) "X" )) ))) )

(deftest prints-and-formats (is (= "123\n456\n789\n" (with-out-str (print-and-format (create-board))))))

(deftest make-multiple-human-moves (is (= "1X3\n456\n789\n1XO\n456\n789\n" (with-out-str (with-in-str "2\n3" (game-loop (create-board)))))))
