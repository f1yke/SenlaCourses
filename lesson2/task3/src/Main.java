public class Main {

    public static void main(String[] args) {

        ILineStep body = new BodyStepLine();
        ILineStep chassis = new ChassisStepLine();
        ILineStep engine = new EngineStepLine();

        AssemblyLine assembly = new AssemblyLine(body, chassis, engine);
        assembly.assembleProduct(new Car());

        System.out.println("Product creation complete!");
    }
}
