(ns lein-trampoline-aot.core-test
  (:require
   [clojure.test :refer :all]
   [lein-trampoline-aot.core :refer :all]))

(deftest foo-test
  (testing "Using `extend-protocol` for `IBar` on `Foo`"
    (is (= "Foo-bar" (bar (->Foo))))))
