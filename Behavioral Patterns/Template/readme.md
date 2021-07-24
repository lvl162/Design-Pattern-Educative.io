## What is it?

A template can be thought of as a general or abstract structure that can be customized for specific situations. You may have used a template for writing your resume. The template would define the overall structure of the document and leave the details to be added in by the template user. The template method pattern is similar, it defines the skeleton or steps of an algorithm but leaves opportunities for subclasses to override some of the steps with their own implementations.

Formally, the pattern is defined as **allowing subclasses to define parts of an algorithm without modifying the overall structure of the algorithm.**

## Example

- Trước khi máy bay cất cánh sẽ có một check list, đóng vai trò là template, máy bay F16 sẽ kế thừa những check cần thiết, và thêm những check đặc biệt chưa có trong template
- Java's applets have gone down in popularity but the applet framework exposed a number of hooks for the developers. For instance, the start method gave the application a chance to take action before the applet just got displayed in the browser.
- The java.io package has an abstract read() method in InputStream that subclasses must implement and is in turn invoked by the method read(byte arg1[], int offet, int length).
  The class javax.servlet.http.HttpServlet has a bunch of methods doGet, doPost and doPut etc, that can be overriden by implementing classes.

Caveats

## Caveats

- Don't confuse the template method pattern with the strategy pattern. Strategy pattern uses composition by accepting objects that define the entire algorithm, whereas the template pattern method uses inheritance to vary parts of the algorithm by subclasses but the outline and structure of the algorithm is still the realm of the abstract class.

- Factory method pattern is a specialization of the template method pattern.

- Ideally, the number of methods for which the subclasses need to provide implementation should be minimized when applying the template method pattern.
