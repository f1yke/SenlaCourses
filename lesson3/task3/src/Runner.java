public class Runner {

    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet(5);

        Flower rose = new Rose();
        Flower orchid = new Orchid();
        Flower lily = new Lily();
        Flower chrysanthemum = new Chrysanthemum();
        Flower peony = new Peony();

        bouquet.addFlower(rose);
        bouquet.addFlower(orchid);
        bouquet.addFlower(lily);
        bouquet.addFlower(chrysanthemum);
        bouquet.addFlower(peony);

        Printer.printBouquet(bouquet.getFlowers());
        Printer.printPrice(bouquet.getBouquetCost());
    }
}
