import java.util.Date;

public class Electronic_Devices extends Product
{
    private String type, brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Electronic_Devices(String name, String id, int quantity, double price, String type, String brand) {
        super(name, id, quantity, price);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Electronic_Devices{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                "} " + super.toString();
    }
}
