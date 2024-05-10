package OOP.Polymorphism;

public class Test03 {
    public static void main(String[] args) {
        Bank b1 = new ARG();
        Bank b2 = new VCB();
        Bank b3 = new CTG(); // upcasting
        System.out.println("VCB lai suat la: " + b1.getRateOfInterest());
        System.out.println("AGR lai suat la: " + b2.getRateOfInterest());
        System.out.println("CTG lai suat la: " + b3.getRateOfInterest());
        System.out.println(b2.speedlimit);
    }
}
