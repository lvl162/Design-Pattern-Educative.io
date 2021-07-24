## What is it?

The decorator pattern adds new functionality to objects without modifying their defining classes.

The decorator pattern can be thought of as a wrapper or more formally a way to enhance or extend the behavior of an object dynamically. The pattern provides an alternative to subclassing when new functionality is desired.

The strategy is to wrap the existing object within a decorator object that usually implements the same interface as the wrapped object. This allows the decorator to invoke the methods on the wrapped object and then add any additional behavior. Usually, the decorator adds behavior to the existing functionality of the wrapped object i.e. the decorator takes action either before or after invoking some method on the wrapped object.

## Example

Ví dụ máy bay có base weight, thêm các func mới sẽ thay đổi func, track base-weight dùng decorator pattern thay vì tạo subclass
Aircraft implements IAircraft (attr: baseWeight, getBaseWeight need to override);
Abstract Decorator implements IAircraft -> this is **WRAPPER**
Func1 (attr: IAircraft aircraft on constructor) extends Decorator: override getBaseWeight { fix_for_func1 + this.aircraft.getBaseWeight()}
Add new func2
Func2(attr: IAircraft aircraft on constructor) implements Decorator: override getBaseWeight { fix_for_func2 + this.aircraft.getBaseWeight()}

# Caveats

One of the issues with the decorator pattern is that we may end up with too many classes as the number of decorators grows. The java.io package suffers from the same issue, as it makes extensive use of the decorator pattern.

Also, if we want to take a specific action based on the concrete type of the plane, we may not be able to do so. Once the concrete object is wrapped inside a decorator the reference to the object is through the abstract type and not the concrete type anymore.
