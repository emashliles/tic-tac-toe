(ns tic-tac-toe.board-evaluation)

(defn l-r-diagonal [] [:0 :4 :8])
(defn r-l-diagonal [] [:2 :4 :6])
(defn columns [] [:0 :3 :6 :1 :4 :7 :2 :5 :8])

(defn winning-line? [source-line]
  (let [line (into #{} source-line)]
   (cond (contains? line  "") false
         (= 1 (count line)) true
         :else false)))

(defn evaluate-lines [lines] (some winning-line? lines))

(defn separate-lines [board] (partition 3 (vals board)))

(defn winning-row? [board]
  (separate-lines board))

(defn winning-column? [board]
  (separate-lines (select-keys board (columns) )))

(defn winning-l-r-diagonal? [board]
  (winning-line? (vals (select-keys board (l-r-diagonal)))))

(defn winning-r-l-diagonal? [board]
  (winning-line? (vals (select-keys board (r-l-diagonal)))))

(defn is-tie? [board]
  (let [marker-set (set (vals board))]
   (if (contains? marker-set "") 
        false
        true)))

(defn is-win? [board]
  (or (evaluate-lines (winning-row? board)) (evaluate-lines (winning-column? board)) (winning-l-r-diagonal? board) (winning-r-l-diagonal? board)))


