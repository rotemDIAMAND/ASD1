package test;

public class Number extends Expression {
    private double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double calculate() {
        return value;
    }
}
