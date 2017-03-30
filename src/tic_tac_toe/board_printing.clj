(ns tic-tac-toe.board-printing)

(defn format-board-keywords [board]
      (map  (fn  [[k v]] 
              (if (= v "")
              (str (+ 1 (read-string (name k))))
              (str v)
) ) board))

(defn print-board [formatted-board](println formatted-board))

(defn str-insert
  [source insert index]
  (str  (subs source 0 index) insert  (subs source index)))

(defn format-board [board]
     (str-insert (str-insert (apply str (format-board-keywords board)) "\n" 3) "\n" 7))

