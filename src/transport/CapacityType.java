package transport;

public enum CapacityType {
    SPECIAL_SMALL(0, 10),
    SMALL(11,25),
    AVERAGE(26,50),
    LARGE(51,80),
    EXTRA_LARGE(81, 120);

    private final Integer from;
    private final Integer to;

    CapacityType(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }
}
