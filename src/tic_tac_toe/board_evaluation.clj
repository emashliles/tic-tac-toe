(ns tic-tac-toe.board-evaluation)

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
  (separate-lines (select-keys board [:0 :3 :6 :1 :4 :7 :2 :5 :8])))

(defn winning-l-r-diagonal? [board]
  (winning-line? (vals (select-keys board [:0 :4 :8]))))

(defn winning-r-l-diagonal? [board]
  (winning-line? (vals (select-keys board [:2 :4 :6]))))

(defn is-tie? [board]
  (let [marker-set (set (vals board))]
   (if (contains? marker-set "") 
        false
        true)))

(defn is-win? [board]
  (or (evaluate-lines (winning-row? board)) (evaluate-lines (winning-column? board)) (winning-l-r-diagonal? board) (winning-r-l-diagonal? board)))


