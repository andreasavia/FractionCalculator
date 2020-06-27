import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Fraction a = new Fraction(4,8);
        Fraction b = new Fraction(2,8);
        Fraction sum = a.add(b);
        System.out.println(sum.toString());

    }
    public String getOperation(Scanner input) {
        return "placeholder";

    }
    public boolean validFraction(String input) {
        return false;
    }
    /* public Fraction getFraction(Scanner input) {

    } */
}