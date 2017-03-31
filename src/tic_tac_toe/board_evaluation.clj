(ns tic-tac-toe.board-evaluation)

(defn row-is-win?
[source-row]
(let [row (into #{} source-row)]
(cond (contains? row  "") false
      (= 1 (count row)) true
:else false)))

(defn get-row-sets [rows]
(some row-is-win? rows))

(defn winning-row? [board]
(partition 3 (vals board)))

(defn winning-column? [board]
(winning-row? (select-keys board [:0 :3 :6 :1 :4 :7 :2 :5 :8]) )
)

(defn winning-l-r-diagonal [board]
(row-is-win? (vals (select-keys board [:0 :4 :8]) ) )
)

(defn winning-r-l-diagonal [board]
(row-is-win? (vals (select-keys board [:2 :4 :6]) ) )
)

(defn is-tie? [board]
(let [marker-set (set (vals board)) ]
(if (contains? marker-set "") false
true
)))

(defn is-win? [board]
 (or (get-row-sets (winning-row? board)) (get-row-sets (winning-column? board)) (winning-l-r-diagonal board) (winning-r-l-diagonal board))
)


