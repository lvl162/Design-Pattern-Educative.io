## What is it

the pattern is defined as **_sharing state among a large number of fine-grained objects for efficiency_**
intrinsic state: nội tại số phi công static final
extrinsic state: ngoại tại số xăng còn, tọa độ
[More information about _static final_ vs _final_](https://stackoverflow.com/questions/15655012/how-does-the-final-keyword-in-java-work-i-can-still-modify-an-object)

## Example

## Caveats

Usually, we don't want the clients to creat the flyweight objects directly. A flyweight factory is used to manage the flywieght objects.

It might appear that flyweight pattern is maybe similar to the singleton pattern, however there are some important differences. Flyweights are immutable whereas a singleton can undergo changes. Also, a singleton can only have a single copy whereas flyweights can have more than one object of their type.

State and Strategy objects are often implemented as flyweights.

In practice, composite pattern can be combined with flyweight to create a hierarchical structure, where the leaves are implemented as flyweight objects and are shared.

Since flyweight objects are shared, identity tests for conceptually different objects would return true.

Memory savings increase if the extrinsic state can be computed rather than being stored. However, the calculation or lookup of the extrinsic state trades execution time increase in lieu of memory savings.
