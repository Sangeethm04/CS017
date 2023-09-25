public abstract class Product implements Comparable < Product > {
    private long id;
    private String name;
    private double price;
    private int quantity;

    protected Product() {
        id = 0;
        name = "none";
        price = 0.0;
        quantity = 0;
    }
    protected Product(long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public long getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setID(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int compareTo(Product p) {
        if (this.getPrice() < p.getPrice()) {
            return -1;
        } else if (this.getPrice() > p.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("%-10d\t%-20s\t$%-5.2f\t%-10d", id, name, price, quantity);
    }
}