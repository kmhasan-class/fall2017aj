package bd.ac.seu.aj.streamlabtask.model;

public enum Grade {
    A ("A", 3.75),
    A_MINUS ("A-", 3.50),
    A_PLUS ("A+", 4.00),
    AB ("AB", 0.00),
    B ("B", 3.00),
    B_PLUS ("B+", 3.25),
    B_MINS ("B-", 2.75),
    C ("C", 2.25),
    C_PLUS ("C+", 2.50),
    D ("D", 2.00),
    F ("F", 0.00),
    I ("I", 0.00),
    R ("R", 0.00),
    S ("S", 4.00),
    U ("U", 0.00);

    private String letterGrade;
    private double numericGrade;

    Grade(String letterGrade, double numericGrade) {
        this.letterGrade = letterGrade;
        this.numericGrade = numericGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public double getNumericGrade() {
        return numericGrade;
    }

    @Override
    public String toString() {
        return letterGrade;
    }
}