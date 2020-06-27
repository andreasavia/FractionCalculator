public class Fraction {
    private int num;
    private int den;

    public Fraction(int myNum, int myDen) {
        if (myDen==0) { // catches denominator equals to 0
            throw new IllegalArgumentException("The denominator is equal to zero");
        } else {
            if (myDen>0) { // denominator positive
                num = myNum;
                den = myDen;
            } else { // denominator negative
                if (myNum >= 0) { // numerator positive
                    num = -myNum;
                    den = Math.abs(myDen); 
                } else { // numerator negative
                    num = Math.abs(myNum);
                    den = Math.abs(myDen);
                }

            }
        }
    }

    /*
    public int getNumerator() {

    }
    public int getDenominator() {

    }
    public String toString() {

    }
    public double toDouble() {

    }   
    public Fraction add(Fraction other) {

    }
    public Fraction subtract(Fraction other) {

    }
    public Fraction multiply(Fraction other) {

    }
    public Fraction divide(Fraction other) {

    }
    public boolean equals(Object other) {

    }
    public void toLowestTerms() {

    }
    public int gcd(int num, int den) {

    }
    */
}