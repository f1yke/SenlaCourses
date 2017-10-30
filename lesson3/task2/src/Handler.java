public class Handler {

    public static int generateNumber() {
        return 100 + (new java.util.Random()).nextInt(999 - 101 );
    }

    public static int getLargestNumeral(int number) {
        int tmp = number;
        int result = getNumeral(tmp);

        while(tmp > 0) {
            tmp /= 10;
            result = result < getNumeral(tmp) ? getNumeral(tmp) : result;
        }
        return result;
    }

    private static int getNumeral(int number) {
        return number % 10;
    }

}
