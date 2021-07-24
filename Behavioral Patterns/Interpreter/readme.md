## What is it?

## Example
- `java.util.Pattern` is a compiled representation of a regular expression.
- `java.text.Normalizer` provides functionality to transform Unicode text.
## Caveats 
- The `interpret()` method can also be put in a visitor object instead of putting it in the expression classes.
- The terminal symbols can also implemented as flyweight objects.
- Its easy to implement, extend and change grammars with limited rules that are implemented using the interpreter pattern. However grammars will lots of rules become hard to manage since there's one class per rule in the interpreter pattern.