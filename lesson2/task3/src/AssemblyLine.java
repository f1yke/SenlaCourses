public class AssemblyLine implements IAssemblyLine {

    private ILineStep body;
    private ILineStep chassis;
    private ILineStep engine;

    public AssemblyLine(ILineStep body, ILineStep chassis, ILineStep engine) {
        this.body = body;
        this.chassis = chassis;
        this.engine = engine;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {

        Body body = (Body) new BodyStepLine().buildProductPart();
        Chassis chassis = (Chassis) new ChassisStepLine().buildProductPart();
        Engine engine = (Engine) new EngineStepLine().buildProductPart();

        System.out.println("Parts creation complete!");
        System.out.println("Installing parts....");

        product.installFirstPart(body);
        product.installSecondPart(chassis);
        product.installThirdPart(engine);

        System.out.println("Parts installation complete!");

        return product;
    }
}
