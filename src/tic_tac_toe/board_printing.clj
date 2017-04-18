(ns tic-tac-toe.board-printing)

(defn clear-screen []  "\u001b[2J\u001B[0;0f")
(defn line-separator [] "\n---------------\n")

(defn create-space-numbers-from-keywords [board]
  (map  (fn  [[k v]] 
   (if (= v "")
    (str "| " (+ 1 (read-string (name k))) " |")
    (str "| " v " |"))) board))

(defn print-board [formatted-board] 
  (print (clear-screen))
  (println formatted-board))

(defn add-newlines [source insert index]
  (str (subs source 0 index) insert (subs source index)))

(defn format-board [board]
  (add-newlines (add-newlines (apply str (create-space-numbers-from-keywords board)) (line-separator) 15) (line-separator) 47))

