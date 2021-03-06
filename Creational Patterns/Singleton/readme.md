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

note 1: volatile mean m???i l???n ?????c bi???n volatile s??? ???????c ?????c t??? b??? nh??? ch??nh c???a m??y t??nh ch??? kh??ng ph???i t??? b??? ?????m CPU v?? m???i h??nh ?????ng ghi v??o bi???n volatile s??? ???????c ghi v??o b??? nh??? ch??nh ch??? kh??ng ch??? ghi v??o b??? ?????m CPU. M???i thay ?????i l??n bi???n s??? ??c ghi ngay v??o main mem thay v?? cpu mem

- th1: 2 lu???ng, 1 lu???ng ghi, 1 lu???ng ch??? ?????c 1 bi???n, volatile ho??n to??n ????? ????? ?????m b???o
- th2: 2 lu???ng ?????u c?? ghi, th?? ph???i d??ng th??n sync
  note 2: singleton ho??n to??n c?? th??? c?? l???p con b???ng c??ch set constructor protected, trong usecase nh?? mu???n ????ng k?? m???t singleton cho m???t t??nh n??ng nh???t ?????nh, v?? nh???n v??o parameter (c?? th??? t??? env var) cho getInstance
