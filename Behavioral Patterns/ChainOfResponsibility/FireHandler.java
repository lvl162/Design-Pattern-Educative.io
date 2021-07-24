package ChainOfResponsibility;

public class FireHandler extends AbstractHandler {

    // Only interested in handling requests with code 1
    private static int code = 1;

    public FireHandler(AbstractHandler successor) {
        super(successor);
    }

    @Override
    public void handleRequest(AbstractRequest request) {
        if (code == request.getRequestCode()) {
            // Handle the request here.
            System.out.println("FireHandler: Handled the request which has code is " + code);
        } else {
            // If the handler, doesn't handle these type of
            // requests, it can just call the super class's
            // forward request method.
            System.out.println("FireHandler: Cannot the request which has code is " + code + "\nNext");

            super.handleRequest(request);
        }
    }
}