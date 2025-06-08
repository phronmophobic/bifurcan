(ns build
  (:require [clojure.tools.build.api :as b]))

;; (def lib 'io.lacuna/bifurcan)
;; (def version "0.2.0-rc1")
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
;; (def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn compile [_]
  (b/javac {:src-dirs ["src"]
            :class-dir class-dir
            :basis basis
            :javac-opts ["-source" "1.8" "-target" "1.8"]}))

