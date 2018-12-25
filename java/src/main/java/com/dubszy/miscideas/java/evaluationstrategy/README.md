## Java's Evaluation Strategy

This package demonstrates mutating objects using only a reference created to the
initial object, and not using the initial object reference itself.

Running the main method in `Test` demonstrates that Java is call-by-sharing.
This means that Java is pass-by-value, but when the value passed is an object,
the object reference is the value passed, not the object itself. Thus, the
initial object can be mutated by mutating a separate object it is assigned to.

Note that the initial object must be mutable for this to work. Also note that
mutable is not the same as accessible. Inaccessible fields on external classes
(private, package-private, or protected fields) can be mutated using this method
as well (which is demonstrated by `ObjectMutator.mutateSomeoneElsesMap(Map)` and
the usage of that method in
`ExternalObjectMutator.mutateMyMapFromOutsideMyself()`)

Maps are used to demonstrate this behavior because simple objects such as
`String` and `BigDecimal` tend to create new object references when they are
mutated using traditional means, therefore not demonstrating this behavior.
