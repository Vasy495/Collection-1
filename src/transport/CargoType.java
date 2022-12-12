package transport;

public enum CargoType {
    N1(0D, 3.5),
    N2(3.5, 12D),
    N3(12D,null);

    private final Double from;
    private final Double to;

    CargoType(Double from, Double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
