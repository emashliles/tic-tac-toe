(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :refer :all]
            [tic-tac-toe.board :refer :all]
))

(deftest start-game (is (= "123\n456\n789\n" (with-out-str (start)))))

(deftest take-human-turn (is (= "1X3\n456\n789\n" (with-out-str (with-in-str "2" (human-turn (create-board))) ))) )

(deftest prints-and-formats (is (= "123\n456\n789\n" (with-out-str (print-and-format (create-board))))))
