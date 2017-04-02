(ns tic-tac-toe.board-printing)

(defn create-space-numbers-from-keywords [board]
  (map  (fn  [[k v]] 
   (if (= v "")
    (str "| " (+ 1 (read-string (name k))) " |")
    (str "| " v " |"))) board))

(defn print-board [formatted-board] 
  (print "\u001b[2J")
  (print "\u001B[0;0f")
  (println formatted-board))

(defn add-newlines [source insert index]
  (str (subs source 0 index) insert (subs source index)))

(defn format-board [board]
  (add-newlines (add-newlines (apply str (create-space-numbers-from-keywords board)) "\n---------------\n" 15) "\n---------------\n" 47))

