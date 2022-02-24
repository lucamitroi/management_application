public class Tools extends Product
{
    private String toolType;

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public Tools(String name, String id, int quantity, double price, String toolType) {
        super(name, id, quantity, price);
        this.toolType = toolType;
    }

    @Override
    public String toString() {
        return "Tools{" +
                "toolType='" + toolType + '\'' +
                "} " + super.toString();
    }
}
