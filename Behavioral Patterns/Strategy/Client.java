package Strategy;

public class Client {

    private int[] numbers = new int[] { 5, 7, 8, 1, 11, 0 };

    void showNumbers() {
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    void crunchingNumbers() {

        // Choose the sorting strategy
        BubbleSort bubbleSort = new BubbleSort();

        // Context receives the strategy object
        Context context = new Context(bubbleSort);

        // Sort the numbers
        context.sort(numbers);

        // Do remaining work
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.crunchingNumbers();
        c.showNumbers();
    }
}