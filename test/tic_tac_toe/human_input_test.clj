(ns tic-tac-toe.human-input-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.human-ui :refer :all]))

(deftest get-user-selection (is (= "1" (with-in-str "2" (get-human-selection)) )))

(deftest negative-selection-invalid (with-out-str (is (= "0" (with-in-str "-1\n1\n" (get-human-selection))))))

(deftest non-number-invalid (with-out-str (is (= "0" (with-in-str "hello\n1\n" (get-human-selection))))))

(deftest advice-text-for-invalid-input (is (= "Invalid selection. Please enter a number between 1 and 9\n" (with-out-str (with-in-str "invalid\n1\n" (get-human-selection))))))

(deftest finds-valid-selection (is (is-valid? "1" )))

(deftest finds-invalid--string-selection (is not(is-valid? "invalid")))

(deftest finds-invalid-negative-selection (is not(is-valid? "-1")))

