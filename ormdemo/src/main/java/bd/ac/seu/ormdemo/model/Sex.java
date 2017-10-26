package bd.ac.seu.ormdemo.model;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
