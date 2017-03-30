(ns tic-tac-toe.human-ui)

(defn get-human-selection []
      (str (- (read-string (read-line)) 1 )))
