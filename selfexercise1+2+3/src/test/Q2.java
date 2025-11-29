package test;

public class Q2 {
    public static double calc() {
        Expression num10 = new Number(10);
        Expression num2 = new Number(2);
        Expression num3 = new Number(3);
        Expression num4 = new Number(4);

        Expression Minus = new Minus(num3, num4);
        Expression Mul = new Mul(num2, Minus);
        Expression Div = new Div(num10, num2);
        Expression Plus = new Plus(Div, Mul);

        return Plus.calculate();
    }
}
