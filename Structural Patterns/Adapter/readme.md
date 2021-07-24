## What is it?

Đồ điện ở mỹ không thể dùng ở ấn độ vì khác nguồn điện và chuẩn ổ cắm, ví dụ ở mỹ 3 chấu, ấn 2 chấu. Cần một adapter chuyển từ 3 chấu sang 2 chấu để có thể sử dụng.

the adapter pattern is defined as **allowing incompatible classes to work together by converting the interface of one class into another expected by the clients**

## Example

class Aircraft và HotAirBalloon đều có method fly() nhưng của máy bay sẽ khác của HotAirBallon
Ta sẽ override fly dựa trên Adapter pattern

```
public class HotAirBalloon {

    String gasUsed = "Helium";

    void fly(String gasUsed) {
        // Take-off sequence based on the kind of feul
        // Followed by more code.
    }

    // Function returns the gas used by the balloon for flight
    String inflateWithGas() {
        return gasUsed;
    }
}

public interface IAircraft {
    void fly();
}

```

Adapter class

```
public class Adapter implements IAircraft {

    HotAirBalloon hotAirBalloon;

    public Adapter(HotAirBalloon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }

    @Override
    public void fly() {
        String feulUsed = hotAirBalloon.inflateWithGas();
        hotAirBalloon.fly(feulUsed);
    }
    public void main() {

        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        Adapter hotAirBalloonAdapter = new Adapter(hotAirBalloon);

        hotAirBalloonAdapter.fly();
    }
}
```
