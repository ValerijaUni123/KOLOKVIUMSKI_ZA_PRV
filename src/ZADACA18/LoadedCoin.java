package ZADACA18;

import java.util.Random;

public class LoadedCoin extends Coin{
    private double P;

    public LoadedCoin(double P) {
        this.P = P;
    }

    public SIDE flip() {
        Random random = new Random();
        int a = random.nextInt(100);
        if (a<P) {
            return SIDE.HEAD;
        } else {
            return SIDE.TAIL;
        }
    }
}