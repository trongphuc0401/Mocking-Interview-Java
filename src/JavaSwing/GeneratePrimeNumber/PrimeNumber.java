package JavaSwing.GeneratePrimeNumber;

public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumberView primeNumberView = new PrimeNumberView();
        PrimeNumberController primeNumberController = new PrimeNumberController(primeNumberView);
    }
}
