## Singleton

- 1 and only instance of class
- allow globally access

## Multi Thread

The above code will work hunky dory as long as the application is single threaded. As soon as multiple threads start using the class, there's a potential that multiple objects get created. Here's one example scenario:

Thread A calls the method getInstance and finds the onlyInstance to be null but before it can actually new-up the instance it gets context switched out.
Now thread B comes along and calls the getInstance method and goes on to new-up the instance and returns the AirforceOne object.
When thread A is scheduled again, is when the mischief begins. The thread was already past the if null condition check and will proceed to new-up another object of AirforceOne and assign it to onlyInstance. Now there are two different AirforceOne objects out in the wild, one with thread A and one with thread B.
There are two trivial ways to fix this race condition.
One is to add synchronized to the getInstance() method.
`synchronized public static AirforceOne getInstance()`
The other is to undertake static initialization of the instance, which is guaranteed to be thread-safe.
// The sole instance of the class
`private static AirforceOne onlyInstance = new AirforceOne();`
The problem with the above approaches is that synchronization is expensive and static initialization creates the object even if it's not used in a particular run of the application. If the object creation is expensive then static intialization can cost us performance.

## Double-checked locking

The next evolution of our singleton pattern would be to synchronize only when the object is created for the first time and if its already created, then we don't attempt to synchronize the accessing threads. This pattern has a name called "double-checked locking".

```
public class AirforceOneWithDoubleCheckedLocking {

    // The sole instance of the class. Note its marked volatile
    private volatile static AirforceOneWithDoubleCheckedLocking onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private AirforceOneWithDoubleCheckedLocking() {
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }

    // Create a static method for object creation
    synchronized public static AirforceOneWithDoubleCheckedLocking getInstance() {

        // Only instantiate the object when needed.
        if (onlyInstance == null) {
            // Note how we are synchronizing on the class object
            synchronized (AirforceOneWithDoubleCheckedLocking.class) {
                if (onlyInstance == null) {
                    onlyInstance = new AirforceOneWithDoubleCheckedLocking();
                }
            }
        }

        return onlyInstance;
    }
}
```

note 1: volatile mean mọi lần đọc biến volatile sẽ được đọc từ bộ nhớ chính của máy tính chứ không phải từ bộ đệm CPU và mọi hành động ghi vào biến volatile sẽ được ghi vào bộ nhớ chính chứ không chỉ ghi vào bộ đệm CPU. Mọi thay đổi lên biến sẽ đc ghi ngay vào main mem thay vì cpu mem

- th1: 2 luồng, 1 luồng ghi, 1 luồng chỉ đọc 1 biến, volatile hoàn toàn đủ để đảm bảo
- th2: 2 luồng đều có ghi, thì phải dùng thên sync
  note 2: singleton hoàn toàn có thể có lớp con bằng cách set constructor protected, trong usecase như muốn đăng kí một singleton cho một tính năng nhất định, và nhận vào parameter (có thể từ env var) cho getInstance
