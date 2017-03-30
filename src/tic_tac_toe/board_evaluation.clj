(ns tic-tac-toe.board-evaluation)

(defn is-tie? [board]
(if (= 2 (count (set (vals board))))
true
false))
