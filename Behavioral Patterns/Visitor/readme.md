## What is it?

- The visitor pattern allows us to define an operation for a class or a class hierarchy without changing the classes of the elements on which the operation is performed.
- Recall the Airforce class example from the Composite Pattern lesson. The Airforce class is a composite consisting of several different kinds of airplanes. It can be thought of as the object structure on whose elements we want to conduct operations. The elements would be the individual planes that make up the airforce object structure.
- Say if we are tasked with monitoring of various metrics for each aircraft such as remaining fuel, altitude and temperature then one option would be to build this functionality inside the abstract class of all the airplanes. The consequence would be that we'll need to implement the new methods in all the airplane subclasses. Now imagine, a few days later we are tasked with calculating the total price tag for the Airforce. We will now add another method to the abstract airplane class or interface that'll return the price for each individual plane and sum it across all the airplanes.
- There are several problems in our scenario, first the airplane class shouldn't be responsible for monitoring or pricing data. It should just represent the aircraft. With each additional functionality, we'll end up bloating our aircraft classes with new unrelated methods. The visitor patterns lets us out of this dilemma by suggesting to have a separate class that defines the new functionality related to the aircraft. The methods in the AircraftVisitor class would take the aircraft object as an argument and work on it. This saves us from changing our aircraft classes each time we need to support a new functionality relating to the Airforce class.
- Formally, the pattern is defined as defining operations to be performed on elements of an object structure without changing the classes of the elements it works on.
- The pattern is suitable in scenarios, where the object structure class or the classes that make up its elements don't change often but new operations over the object structure are desired.
- Ví dụ máy bay cần có chức năng monitoring và get metrics, nếu gắn thêm hàm và interface hay abstract class Aircraft thì không liên quan và hơi ngu, nên tạo ra class visitor với constructor(Aircraft) được Aircraft accept để thực hiện những chức năng trên

## Example

- java.nio.file.FileVisitor interface has an implementation class of SimpleFileVisitor which is an example of a visitor. The interface is defined as a visitor of files. An implementation of this interface is provided to the Files.walkFileTree methods to visit each file in a file tree.
- javax.lang.model.element.Element interface represents a program element such as a package, class, or method. To implement operations based on the class of an Element object not known at compile an implementation of the javax.lang.model.element.ElementVisitor interface is required.

## Caveats

- The visitor pattern cautions that if one expects the object structure classes to change often then it might be a good idea to just keep the new functionality within the visited classes instead of using the visitor pattern. The key consideration in applying the Visitor pattern is if the algorithm applied over an object structure is more likely to change or the classes of objects that make up the structure. The visitor class hierarchy can be difficult to maintain when new concrete element classes are added frequently. In such cases, it's probably easier just to define operations on the classes that make up the structure. If the Element class hierarchy is stable, but you are continually adding operations or changing algorithms, then the visitor pattern will help you manage the changes.
- Adding new concrete classes will require modifying all the visitor classes, which makes it hard to add new types to the object structure.
- Iteration over the object structure can happen via an iterator, inside the object structure or by the visitor.
- Note that an iterator requires that a composite be made up of elements that all conform to the same base class or interface, whereas a visitor can visit all the elements of a composite even if they are unrelated.
- Languages that support double or multiple dispatch lessen the need for the visitor pattern.
