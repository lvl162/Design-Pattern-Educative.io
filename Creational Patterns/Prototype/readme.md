## What is it?
Là cách để tạo 1 obj mới bằng việc copy từ "existing obj" aka prototype. But why, sao hem tạo 1 cái mới từ constructor. Nguyên do: 
- Đôi khi việc tạo mới tốn kém hơn copy
- Class được load trong runtime, không thể access statically tới constructor. Do đó cần 1 prototype manager để cung cấp các clone
- Giảm số lượng class từ việc tạo prototype

## Example
Ví dụ có class F16, máy bay tuy nhiên có nhiều biến thể. Giả sử các biến thể chỉ khác nhau về engine. 
Nhưng nếu tạo riêng nhiều subclasses thì ngu, nên ta sẽ đẻ F16 class là 1 prototype và setEngine cho các clone. 