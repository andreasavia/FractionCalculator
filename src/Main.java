import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is a fraction calculator.\n" +
        "It will add, subtract multiply and divide fractions until you type Q to quit.\n" + 
        "Please enter your fractions in the form a/b, where a and b are intergers\n" +
        "------------------------------------------------------------------------------------");

        String oper;
        
        do {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        oper = getOperation(input);

        Fraction fract1 = new Fraction();
        Fraction fract2 = new Fraction();

        if (oper.equals("+") || oper.equals("-") || oper.equals("/") || oper.equals("*") && oper.equals("=")) {
            fract1 = getFraction(input);
            fract2 = getFraction(input);
        }
        Fraction result = new Fraction();

        switch (oper) {
            case "+":
                result = fract1.add(fract2);
                System.out.println(fract1.toString() + " + " + fract2.toString() + " = " + result.toString());
                break;
            case "-":
                result = fract1.subtract(fract2);
                System.out.println(fract1.toString() + " - " + fract2.toString() + " = " + result.toString());
                break;
            case "/":
                result = fract1.divide(fract2);
                System.out.println(fract1.toString() + " / " + fract2.toString() + " = " + result.toString());
                break;
            case "*":
                result = fract1.multiply(fract2);
                System.out.println(fract1.toString() + " * " + fract2.toString() + " = " + result.toString());
                break;
            case "=":
                System.out.println(fract1.toString() + " = " + fract2.toString() + " is " + fract1.equals(fract2));
                break;
            case "Q":
                break;
        }
        } while (!oper.equals("Q"));
    } 
    public static String getOperation(Scanner input) {
        String op = input.nextLine();
        // Check input validity
        while (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*") && !op.equals("=") && !op.equals("Q")) {
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            op = input.nextLine();
        }

        return op;
    }
    public static Fraction getFraction(Scanner input) {
        System.out.println("Please enter a fraction (a/b) or integer (a): ");
        String fractStr = input.nextLine();
        while(!validFraction(fractStr)) {
            System.out.println("Invalid fraction. Please enter a fraction (a/b) or (a), where a and b are integers and b is not zero: ");
            fractStr = input.nextLine();
        }
        int[] fractArr = getNum(fractStr);
        Fraction fractObj = new Fraction(fractArr[0],fractArr[1]);
        return fractObj;
    }
    public static boolean validFraction(String input) {
        boolean flag = false;
        if (input.contains("/")) { // num / den case
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '/') {
                    String num = input.substring(0,i);
                    String den = input.substring(i+1, input.length());
                    if (isNumber(num) && isNumber(den) && den != "0") { // TODO Debug
                        flag = true;
                    }
                    break;
                }
            }
        } else { // integer case
            if (isNumber(input)) {
                flag = true;
            }
        }
        return flag;
    }  
    public static boolean isNumber(String input) {
        String testStr = "0123456789";
        boolean test = false; // initialise flag as false
        for (int i = 0; i < input.length(); i++) { // cycle the inputs
            test = false;
            
            if (i == 0 && input.charAt(0) == '-') { // skip first char if equal to '-'
                i++;
                if (input.length() == 1) { //  check if the user has enetered just '-'
                    break; // 
                }
            }
            
            for (int j = 0; j < 10; j++) { // cycle the numbers
                if (input.charAt(i) == testStr.charAt((j))) {
                    test = true;
                    break; // stop cycle when identifed number
                }
            }
            if (test == false) { // check if no number was identified
                break; 
            }
        }
        return test; 
    }
    public static int[] getNum(String input) {
        int[] output = new int[2];   
        
        if (input.contains("/")) { // num / den case
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '/') {
                    output[0] = Integer.parseInt(input.substring(0,i));
                    output[1] = Integer.parseInt(input.substring(i+1, input.length()));
                    break;
                }
            }
        } else { // integer case
            output[0] = Integer.parseInt(input);
            output[1] = 1;
        }
        return output;
    }
}