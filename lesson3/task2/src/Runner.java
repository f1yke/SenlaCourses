public class Runner {
    public static void main(String[] args) {
        int number = Handler.generateNumber();
        Printer.printNumber(number);
        int largestNumeral = Handler.getLargestNumeral(number);
        Printer.printLargestNumeral(largestNumeral);
    }
}
