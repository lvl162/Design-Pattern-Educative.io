## What is it?

- The strategy pattern is one of the simpler patterns to comprehend. It allows grouping related algorithms under an abstraction, which the client codes against. The abstraction allows switching out one algorithm or policy for another without modifying the client.
- The strategy pattern is formally defined as **encapsulating algorithms belonging to the same family and making them interchangeable. The consumers of the common interface that the algorithms implement allow switching out one algorithm for another seamlessly.**

## Example

- For our aircraft scenario, we can think about the different ways an F-16 can be equipped with weapons before each mission. An F-16 can go for reconnaissance without carrying any weapons, it can be loaded with (God forbid) nuclear weapons or it can carry Sidewinder missiles to intercept incoming enemy fighter jets. When modeling this scenario in our code, we could create a ArmingStrategy interface which will have concrete implementations of NoWeapons, NuclearWeapons and AirToAirWeapons as arming strategies for the plane. Before the F16 flies each mission we can set the armingStrategy variable held in the F16 class with the desired arming strategy for the mission.

- java.util.Comparator has the method compare which allows the user to define the algorithm or strategy to compare two objects of the same type.

- Think how a text editor such as Microsoft Word can make use of the strategy pattern when a client chooses the paragraph alignment options. The strategies could be justify text, left-align, right-align or center-align.

## Caveats

- The context can either pass the required data or itself to the strategy object. In the latter case, the context would expose methods on itself so that the strategy object can retrieve the required data.
- Strategy objects are good candidates to be implemented as flyweight objects. This can reduce the memory requirements for the application.
- The context class can be simplified by providing a default strategy and only burdening the clients to provide a strategy object, when the default doesn't meet their requirements.
