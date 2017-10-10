public class BodyStepLine implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Body();
    }
}
