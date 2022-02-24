public class Clothing extends Product
{
    private String  material, type, size, sex;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    public String get_size() {
        return size;
    }

    public void set_size(String _size) {
        this.size = size;
    }

    public String get_sex() {
        return sex;
    }

    public void set_sex(String _sex) {
        this.sex = _sex;
    }

    public Clothing(String id, String name, int quantity, double price, String material, String _type, String _size, String _sex) {
        super(id, name, quantity, price);
        this.material = material;
        this.type = _type;
        this.size = _size;
        this.sex = _sex;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "material='" + material + '\'' +
                ", _type=" + type +
                ", _size=" + size +
                ", _sex=" + sex +
                "} " + super.toString();
    }
}
