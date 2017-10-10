public class Car implements IProduct {

    public IProductPart firstPart;
    public IProductPart secondPart;
    public IProductPart thirdPart;

    @Override
    public void installFirstPart(IProductPart part) {
        this.firstPart = part;
        System.out.println(" Body installation complete!");
    }

    @Override
    public void installSecondPart(IProductPart part) {
        this.secondPart = part;
        System.out.println(" Chassis installation complete!");
    }

    @Override
    public void installThirdPart(IProductPart part) {
        this.thirdPart = part;
        System.out.println(" Engine installation complete!");
    }
}
