package ZADACA11;

public class GenericFraction <T extends Number, U extends Number>{
    private T numerator;
    private U denominator;

    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        if(denominator.equals(0)) throw new ZeroDenominatorException();
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) throws ZeroDenominatorException {
        return new GenericFraction<>(numerator.doubleValue() * gf.denominator.doubleValue()
                            + denominator.doubleValue() * gf.numerator.doubleValue(),
                denominator.doubleValue() * gf.denominator.doubleValue());
    }
    public double toDouble(){
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }
    @Override
    public String toString() {
        int a = gcd(numerator.intValue(), denominator.intValue());
        return String.format("%.2f / %.2f", numerator.doubleValue()/a, denominator.doubleValue()/a);
    }
}
