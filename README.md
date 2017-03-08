# lein-trampoline-aot

Minimal working example (MWE) demonstrating issue with `lein trampoline test`.

## Usage

Run

```
$ lein clean
$ lein trampoline test
```

See that an error like the following is thrown:

```
ERROR in (foo-test) (core_deftype.clj:568)
Using `extend-protocol` for `IBar` on `Foo`
expected: (= "Foo-bar" (bar (->Foo)))
  actual: java.lang.IllegalArgumentException: No implementation of method: :bar of protocol: #'lein-trampoline-aot.core/IBar found for class: lein_trampoline_aot.core.Foo
```
