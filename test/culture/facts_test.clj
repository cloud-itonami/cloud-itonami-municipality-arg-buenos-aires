(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest buenos-aires-has-culture-basis
  (let [sb (facts/spec-basis "buenos-aires")]
    (is (= 10 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "buenos-aires" (:culture/municipality %)) sb))
    (is (every? #(= "ARG" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "cordoba")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["buenos-aires" "cordoba"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["cordoba"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "buenos-aires" :dish))))
  (is (= ["buenos-aires.beverage.mate"]
         (mapv :culture/id (facts/by-kind "buenos-aires" :beverage))))
  (is (empty? (facts/by-kind "buenos-aires" :craft)))
  (is (empty? (facts/by-kind "cordoba" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
