package ZADACA10;

public interface IEvaluator<T extends Comparable<T>> {
    boolean evaluate (T a, T b);
}
