## What is it?

A factory produces goods, and a software factory produces objects. Usually, object creation in Java takes place like so:

`SomeClass someClassObject = new SomeClass();`

The problem with the above approach is that the code using the SomeClass's object, suddenly now becomes dependent on the concrete implementation of SomeClass. There's nothing wrong with using new to create objects but it comes with the baggage of tightly coupling our code to the concrete implementation class, which is a _violation of code to an interface and not to an implementation._

Formally, the factory method is defined as providing an interface for object creation but delegating the actual instantiation of objects to subclasses.

## Diff

The factory method pattern might seem very similar to the simple or static factory, however, the primary difference is that simple factories can't produce varying products through inheritance as a factory method pattern can.

note:

- The pattern can result in too many subclasse with very minor differences.
- If the subclass extends the functionality, then the superclass can't use it unless it downcasts it to the concrete type. The downcast may fail at runtime.
