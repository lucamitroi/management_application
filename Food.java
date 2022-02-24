import java.util.Date;

public class Food extends Product
{
    private String expirationDate;

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Food(String name, String id, int quantity, double price, String expirationDate) {
        super(name, id, quantity, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "expirationDate=" + expirationDate +
                "} " + super.toString();
    }
}
