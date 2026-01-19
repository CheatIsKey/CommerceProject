public enum Grade {
    BRONZE("bronze"),
    SILVER("silver"),
    GOLD("gold"),
    PLATINUM("platinum");

    private final String grade;

    Grade(String grade) {
        this.grade = grade;

    }

    public String getGrade() {
        return grade;
    }


}
