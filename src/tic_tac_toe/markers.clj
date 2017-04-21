(ns tic-tac-toe.markers)

(defn human-marker [] "X")
(defn computer-marker [] "O")

(defn switch-marker [marker] 
  (if (= marker "X")
   "O"
   "X" ))

