public class Furniture extends Product
{
    private String furnitureType, material, environment;

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Furniture(String name, String id, int quantity, double price, String furnitureType, String material, String environment) {
        super(name, id, quantity, price);
        this.furnitureType = furnitureType;
        this.material = material;
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureType='" + furnitureType + '\'' +
                ", material='" + material + '\'' +
                ", environment='" + environment + '\'' +
                "} " + super.toString();
    }
}
