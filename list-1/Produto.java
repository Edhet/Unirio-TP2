public class Main {
    public static void main(String[] args) {
        Product nProd = new Product();
        Product newerProd = new Product("ableubleubleu", 9, 12, 12.2);
        Product newestProd = new Product("Testy", 123, 12, -2.0);
    }
}

class Product {
    private String name;
    private long id, quantity;
    private double price;

    public Product(String name, long id, long quantity, double price) {
        this.setName(name);
        this.setId(id);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public Product() {
        this.name = "";
        this.id = 1;
        this.quantity = 0;
        this.price = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 0)
            return;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0 || id > 9999)
            return;
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        if (quantity < 0)
            return;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0.0)
            return;
        this.price = price;
    }
}