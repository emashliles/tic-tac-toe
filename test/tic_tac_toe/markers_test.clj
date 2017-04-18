(ns tic-tac-toe.markers-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.markers :refer :all]))

(deftest switch-O-to-X (is (= "X" (switch-marker "O"))))

(deftest switch-X-to-O (is (= "O" (switch-marker "X"))))
