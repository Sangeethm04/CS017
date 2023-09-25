public class Magazine extends Product {
    private int issue;

    public Magazine() {
        super();
        issue = 0;
    }
    public Magazine(long id, String name, double price, int quantity, int issue) {
        super(id, name, price, quantity);
        this.issue = issue;
    }
    public int getIssue() {
        return issue;
    }
    public void setIssue(int issue) {
        this.issue = issue;
    }
    @Override
    public String toString() {
        return String.format("%-10s\t%s\t%-10d", "Magazine", super.toString(), issue);
    }
}