public class ChassisStepLine implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        return new Chassis();
    }
}
