(ns tic-tac-toe.board)

(defn create-board []
  (sorted-map :0 "", :1 "", :2 "", :3 "", :4 "", :5 "", :6 "", :7 "", :8 "")) 

(defn place-marker [space marker board]
  (assoc board space marker))

(defn available-spaces [board]
 (map first (filter (comp #{ "" } last )board ))
)
