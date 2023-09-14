public class Faculty extends Employee {
    private String rank;

    public Faculty() {
        super();
        rank = "Assisant Professor";
    }

    public Faculty(int id, String name, String address, String phone, String email, String position, double salary, String rank) {
        super(id, name, address, phone, email, position, salary);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
    public void setRank(String r) {
        this.rank = r;
    }

    public String toString() {
        return super.toString() + "Rank: " + rank + "\n";
    }
}