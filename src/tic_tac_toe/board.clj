(ns tic-tac-toe.board)

(defn empty-space [] "")

(defn create-board []
  (sorted-map :0 (empty-space), :1 (empty-space), :2 (empty-space), :3 (empty-space), :4 (empty-space), :5 (empty-space), :6 (empty-space), :7 (empty-space), :8 (empty-space))) 

(defn place-marker [space marker board]
  (assoc board space marker))

(defn available-spaces [board]
 (map first (filter (comp #{ (empty-space) } last ) board ))
)
