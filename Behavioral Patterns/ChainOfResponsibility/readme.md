## What is it?

In a chain of responsibility pattern implementation, the sender's request is passed down a series of handler objects till one of those objects, handles the request or it remains unhandled and falls off the chain. Multiple objects are given a chance to handle the request. This allows us to decouple the sender and the receiver of a request.

The requestor has no knowledge of the object that will eventually handle its request nor does it have a reference to the handling object. Similarly, the object eventually handling the request isn't aware of the requestor.

Each object in the chain should implement a common supertype and have a reference to its successor. The handler objects can be added to or removed from the chain at runtime.

Formally, the pattern is defined as decoupling the sender of a request from its receiver by chaining the receiving objects together and passing the request along the chain until an object handles it.

Usually the pattern is applied when the request can be handled by multiple objects and it is not known in advance which object will end up handling the request.

## Example

Filters and Pipelines Architecture like design patterns
middleware, filter...

## Caveats

To form the handler chain, individual objects might need to store references to their successors. However, in certain cases the links might already exist such as that in a composite structure like a tree.
Trong mỗi node cần xác định next kế vị. Mỗi node có vai trò giống nhau như trong composition pattern
