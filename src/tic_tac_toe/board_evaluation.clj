(ns tic-tac-toe.board-evaluation)

(defn row-is-win?
[row]
(= 1  (count  (into #{} row)))
)

(defn get-row-sets [rows]
(some row-is-win? rows)

)

(defn winning-row? [board]
(partition 3 (vals board))
)

(defn is-tie? [board]
(if (= 2 (count (set (vals board))))
true
false))

(defn is-win? [board]
(if (winning-row? board)
true
false
))


