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
    } 
    public String toString() {
        return this.num + "/" + this.den;
    }
    public double toDouble() {
        return this.num / this.den;
    }
    public Fraction add(Fraction other) {
        int added_den = this.den * other.den;
        int added_num = (this.num * other.den) + (other.num * this.den);
        Fraction added = new Fraction(added_num,added_den);
        added.toLowestTerms();;
        return added;
    }
    public Fraction subtract(Fraction other) {
        int sub_den = this.den * other.den;
        int sub_num = (this.num * other.den) - (other.num * this.den);
        Fraction sub = new Fraction(sub_num,sub_den);
        sub.toLowestTerms();;
        return sub;
    }
    public Fraction multiply(Fraction other) {
        Fraction prod = new Fraction(this.num * other.num, this.den * other.den);
        return prod;
    }
    public Fraction divide(Fraction other) {
        Fraction div = new Fraction(this.num * other.den, this.den * other.num);
        return div;
    }
    public boolean equals(Object other) {
        Fraction new_other = new Fraction();    
        new_other = (Fraction) other;
        return (this.toDouble() == new_other.toDouble());
    }
    public void toLowestTerms() {
        int fract_gcd = gcd(this.num, this.den);
        this.num = this.num / fract_gcd;
        this.den = this.den / fract_gcd;
    }
    public int gcd(int num, int den) { // find greatest common denominator
        int rem;
        while (num != 0 && den !=0) {
            rem = num % den;
            num = den;
            den = rem;
        }
        return num;
    }
}