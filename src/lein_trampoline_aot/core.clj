(ns lein-trampoline-aot.core)

(defprotocol IFoo
  (foo [_] "Ifoo"))

(deftype Foo []
  IFoo
  (foo [_] "Foo"))

(defprotocol IBar
  (bar [_] "Ibar"))

(extend-protocol IBar
  Foo
  (bar [_]
    "Foo-bar"))
