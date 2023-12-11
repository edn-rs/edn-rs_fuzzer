(ns fuzzer.core
  (:import [foo.bar Rust])
  (:require [clojure.test-clojure.generators :as cgen]
            [clojure.edn :as cljedn])
  (:gen-class))

(defn- init! []
  (clojure.lang.RT/loadLibrary "edn_rs"))

(defn -main
  [& args]
  (init!)
  (dotimes [_ 10]
    (let [edn (pr-str (cgen/ednable))
          ; edn-rs doesn't preserve order on hashmaps or sets. For now we just use clojure's
          ; read-string to make sure the round trip is valid edn.
          edn-rs (-> (Rust/roundtrip edn) cljedn/read-string pr-str)] 
      (when-not (= edn edn-rs)
        (prn edn)
        (println "")
        (prn edn-rs)))))

