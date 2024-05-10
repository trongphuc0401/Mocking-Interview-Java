package JavaSwing.Caculate;

public class Calculator {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);
    }
}
