package tests;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int divInt(int a, int b) {
        return a / b;
        //return  (double) a / b; - можно использовать double, тогда проверки на ноль  будут такие же, как и в divDouble методе
    }

    public double divDouble(double a, double b) {
        return a / b;
    }
}
