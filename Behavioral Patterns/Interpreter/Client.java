package Interpreter;

public class Client {

    public static void main(String args[]) {
        AbstractSyntaxTree ast = new AbstractSyntaxTree();

        Context context = new Context("glide splitS glide barelRoll glide");

        while (ast.hasNext()) {
            Program node = ast.getNextNode();
            node.interpret(context);
        }
    }
}