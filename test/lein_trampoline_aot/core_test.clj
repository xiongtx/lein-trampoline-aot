(ns lein-trampoline-aot.core-test
  (:require
   [clojure.test :refer :all]
   [lein-trampoline-aot.core :refer :all]))

(deftest foo-test
  (testing "Using `extend-protocol` for `IBar` on `Foo`"
    (println "Classloader for lein_trampoline_aot.core.Foo: " (.getClassLoader lein_trampoline_aot.core.Foo))
    (println "Classloader for (->Foo): " (.getClassLoader (type (->Foo))))
    (is (= "Foo-bar" (bar (->Foo))))))
