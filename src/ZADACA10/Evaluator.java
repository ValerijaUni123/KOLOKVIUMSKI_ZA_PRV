package ZADACA10;

import java.util.Comparator;

public class Evaluator<T> {
    public static<T extends Comparable<T>> boolean evaluateExpression (T left, T right, String operator){
        IEvaluator<T> evaluator = EvaluatorBuilder.build(operator);
        return evaluator.evaluate(left, right);
    }
}
