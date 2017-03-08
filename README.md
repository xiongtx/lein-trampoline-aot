# lein-trampoline-aot

Minimal working example (MWE) demonstrating issue with `lein trampoline test`.

## Usage

Run

```
$ lein clean
$ lein trampoline test
```

See that the classloaders for `lein_trampoline_aot.core.Foo` and that of a newly created `Foo`, `(->Foo)`, are different:

```
Classloader for lein_trampoline_aot.core.Foo:  #object[clojure.lang.DynamicClassLoader 0x4982cc36 clojure.lang.DynamicClassLoader@4982cc36]
Classloader for (->Foo):  #object[sun.misc.Launcher$AppClassLoader 0x55f96302 sun.misc.Launcher$AppClassLoader@55f96302]
```

and that the `extend-protocol`, therefore, fails to extend the class of `(->Foo)`, resulting in an error:


```
ERROR in (foo-test) (core_deftype.clj:568)
Using `extend-protocol` for `IBar` on `Foo`
expected: (= "Foo-bar" (bar (->Foo)))
  actual: java.lang.IllegalArgumentException: No implementation of method: :bar of protocol: #'lein-trampoline-aot.core/IBar found for class: lein_trampoline_aot.core.Foo
```

Using `lein test` instead of `lein trampoline` test gives the same classloaders, and therefore a passing test:

```
Classloader for lein_trampoline_aot.core.Foo:  #object[sun.misc.Launcher$AppClassLoader 0x55f96302 sun.misc.Launcher$AppClassLoader@55f96302]
Classloader for (->Foo):  #object[sun.misc.Launcher$AppClassLoader 0x55f96302 sun.misc.Launcher$AppClassLoader@55f96302]

Ran 1 tests containing 1 assertions.
0 failures, 0 errors.
```
