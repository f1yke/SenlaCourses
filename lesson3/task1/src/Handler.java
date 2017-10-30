public class Handler {

    public static int getSum(String[] numbers) {
        int result = 0;
        for (String str: numbers) {
            result += Integer.parseInt(str);
        }
        return result;
    }
}
