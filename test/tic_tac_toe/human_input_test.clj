(ns tic-tac-toe.human-input-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.human-ui :refer :all]))

(deftest get-user-selection (is (= "1" (with-in-str "2" (get-human-selection)) )))

(deftest negative-selection-invalid (is (= "0" (with-in-str "-1\n1\n" (get-human-selection)))))

(deftest non-number-invalid (is (= "0" (with-in-str "hello\n1\n" (get-human-selection)))))

(deftest finds-valid-selection (is (is-valid? "1" )))

(deftest finds-invalid--string-selection (is not(is-valid? "hello")))

(deftest finds-invalid-negative-selection (is not(is-valid? "-1")))
