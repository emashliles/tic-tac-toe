(ns tic-tac-toe.board-printing)

(defn clear-screen []  "\u001b[2J\u001B[0;0f")
(defn line-separator [] "\n---------------\n")
(defn first-separator-index [] 15)
(defn second-separator-index [] 47)

(defn create-space-numbers-from-keywords [board]
  (map  (fn  [[k v]] 
   (if (= v "")
    (str "| " (+ 1 (read-string (name k))) " |")
    (str "| " v " |"))) board))

(defn print-board [formatted-board] 
  (print (clear-screen))
  (println formatted-board))

(defn insert-separator [source insert index]
  (str (subs source 0 index) insert (subs source index)))

(defn add-separators [board] 
  (insert-separator
    (insert-separator board (line-separator) (first-separator-index))
      (line-separator) (second-separator-index)))

(defn format-board [board]
  (add-separators (apply str (create-space-numbers-from-keywords board))))

