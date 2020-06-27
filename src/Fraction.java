public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        if (den==0) { // catches denominator equals to 0
            throw new IllegalArgumentException("The denominator is equal to zero");
        } else {
            if (den>0) { // denominator positive
                this.num = num;
                this.den = den;
            } else { // denominator negative
                if (num >= 0) { // numerator positive
                    this.num = -num;
                    this.den = Math.abs(den); 
                } else { // numerator negative
                    this.num = Math.abs(num);
                    this.den = Math.abs(den);
                }

            }
        }
    }
    public Fraction(int num) {
        this(num,1);
    }
    public Fraction() {
        this(0,1);
    }
    public int getNumerator() {
        return num;
    }
    public int getDenominator() {
        return den;
    } /*
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