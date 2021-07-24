## What is it?

A mediator is defined as a person who makes people involved in a conflict come to an agreement. The pattern definition however, isn't violent and says the pattern is applied to encapsulate or centralize the interactions amongst a number of objects. Object orientated design may result in behavior being distributed among several classes and lead to too many connections among objects. The encapsulation keeps the objects from referring to each other directly and the objects don't hold references to each other anymore.

Formally, the pattern is defined as encouraging loose coupling among interacting objects by encapsulating their interactions in a mediator object, thus avoiding the need for individual objects to refer to each other directly and allowing to vary object interactions independently.

A mediator controls and coordinates the behavior for a group of objects. The objects only communicate with the mediator or the director and don't know of the other objects.

The mediator pattern should be applied when there are many objects communicating in a well-structured but complex manner resulting in interdependencies that are hard to understand. The participant objects in such a scheme don't lend themselves for reuse because of dependence on so many other objects.

Since the interaction rules or behavior is isolated in a single mediator class, it becomes easier to change. Also note that in the absence of the mediator, the objects are engaged in many-to-many interactions but when the mediator is introduced the interactions become one-to-many between the mediator and the other participating objects.

## Example

- Ví dụ trong bối cảnh là một trạm không lưu và một tỉ máy bay. Tất cả máy bay, dù sắp cất hay hạ cánh đều phải quan tâm đến tọa độ của các máy bay khác để biết mức độ sử dụng đường băng hạ cánh cũng như nơi đáp máy bay.
  Để tránh xảy ra tai nạn thì giữa các máy bay cần phải có một interconnections, do đó dẫn đến số kết nối này quá nhiều.
  Với chỉ một đường băng, thì worst case là tất cả máy bay đều phải biết phần còn lại đang bay hay hạ cánh.
  Do vậy, trạm không lưu - mediator đóng vai trò là một hub giúp các máy bay kết nối tới và đảm bảo thông tin liên lạc giữa các máy bay. Do đó thay vì máy bay nói chuyện với tất cả máy bay còn lại, thì giờ chỉ nói chuyện với trạm không lưu.

- **java.util.concurrent.ExecutorService** an Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.

- **java.util.Timer** A facility for threads to schedule tasks for future execution in a background thread. Tasks may be scheduled for one-time execution, or for repeated execution at regular intervals.

## Caveats

The communication between the mediator and other objects, called colleagues, can follow the observer pattern. The mediator acts as the observer and receives notifications from colleagues, which act as subjects. The effects of the change are then forwarded to other colleagues by the mediator.

The pattern trades complexity of interactions for complexity in the mediator. The mediator itself can become very complex and hard to maintain.
