(ns tic-tac-toe.human-input-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.human-ui :refer :all]))

(deftest get-user-selection (is (= "1" (with-in-str "2" (get-human-selection)) )))

