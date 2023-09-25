public class Gift extends Product {
    private String category;

    public Gift() {
        super();
        category = "none";
    }
    public Gift(long id, String name, double price, int quantity, String category) {
        super(id, name, price, quantity);
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return String.format("%-10s\t%s\t%-10s", "Gift", super.toString(), category);
    }
}