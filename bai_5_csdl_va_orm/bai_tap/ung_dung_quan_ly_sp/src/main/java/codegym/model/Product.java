package codegym.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private String origin;

    public Product() {
    }

    public Product(int id, String name, float price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
