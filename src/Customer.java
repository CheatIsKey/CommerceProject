public class Customer {
    private String name;
    private String email;
    private Grade grade;
    private int totalAmount;

    public Customer(String name, String email, Grade grade, int totalAmount) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.totalAmount = totalAmount;
    }
}
