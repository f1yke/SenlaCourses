public class Runner {
    public static void main(String[] args) {
        String[] numbers = generateArray(10);
        Printer.printArray(numbers);
        Printer.printSum(Handler.getSum(numbers));
    }

    public static String[] generateArray(int length) {
        String[] numbers = new String[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = String.valueOf((new java.util.Random()).nextInt(10));
        }
        return numbers;
    }
}
