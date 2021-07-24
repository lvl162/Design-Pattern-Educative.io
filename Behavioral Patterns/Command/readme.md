## What is it?

The command pattern's intention is to decouple the consumers of an action and the object which knows how to perform the action. Let me present an example for clarity. Suppose you are designing a framework for UI, and you add the ability for the users of the framework to add a menu bar. The menu bar will consist of menu-items. When someone clicks on the menu-item some action will be performed. Since you are only building the framework, you don't know what actions the users of the framework can have the menu-item perform. It may vary from opening a document to restarting the application. The command pattern allows us to encapsulate the desired action in an object and the object becomes responsible for invoking the action with the appropriate arguments.

Formally, the pattern is defined as representing an action or a request as an object that can then be passed to other objects as parameters, allowing parameterization of clients with requests or actions. The requests can be queued for later execution or logged. Logging requests enables undo operations.

## Example

A series of commands can be strung together and executed in a sequence by another command object, sometimes called a macro command. It has no explicit receiver as the commands it sequences define their own receivers. The macro command is an example of the composite pattern.

Other Examples
java.lang.Runnable defines the interface implemented by classes whose instances are executed by threads.

Implementations of javax.swing.Action also conform to the command pattern.

## Caveats

The command pattern is equivalent of a callback function in procedural languages as we parametrize objects with an action to perform

The command objects can also be queued for later execution.

The command interface can introduce an unexecute method, which reverses the actions of the execute method. The executed commands can then be stored in a list and traversing the list forwards and backwards while invoking execute or unexecute can support redo and undo respectively. The memento pattern can be helpful in storing the state a command needs to undo its effects.

The command interface can add methods to save and read from disk allowing logging of commands. In case of a crash the log can be read and the commands re-executed in the same sequence to get the system back to the state just before the crash.
