public class Printer {

    public static void printBouquet(Flower[] flowers) {
        StringBuilder sb = new StringBuilder(flowers.length);
        sb.append("[ ");
        for (Flower flower : flowers) {
            sb.append(flower.getName());
            sb.append(" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void printPrice(int price) {
        System.out.println("Price: " + price);
    }

    public static void printError() {
        System.out.println("Error!");
    }
}
