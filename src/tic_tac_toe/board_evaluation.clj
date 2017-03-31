(ns tic-tac-toe.board-evaluation)

(defn row-is-win?
[source-row]
(let [row (into #{} source-row)] 
      (cond (contains? row "") false
            (= 1 (count row)) true)))

(defn get-row-sets [rows]
(some row-is-win? rows))

(defn winning-row? [board]
(partition 3 (vals board))
)

(defn is-tie? [board]
(if (= 2 (count (set (vals board))))
true
false))

(defn is-win? [board]
(winning-row? board))


