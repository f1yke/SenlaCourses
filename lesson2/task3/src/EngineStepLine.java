public class EngineStepLine implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Engine();
    }
}
