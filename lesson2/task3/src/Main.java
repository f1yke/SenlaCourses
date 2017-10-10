public class Main {

    public static void main(String[] args) {

        AssemblyLine assembly = new AssemblyLine();
        Car car = new Car();
        assembly.assembleProduct(car);

        System.out.println("Product creation complete!");
    }
}
