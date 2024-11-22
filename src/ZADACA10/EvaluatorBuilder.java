package ZADACA10;

public class EvaluatorBuilder<T> {

    public static <T extends Comparable<T>>IEvaluator<T> build (String operator){
        if(operator.equals(">")){
            return (a, b) -> a.compareTo(b) > 0;
        }
        else if(operator.equals("<")){
            return (a, b) -> a.compareTo(b) < 0;
        }
        else if(operator.equals("==")){
            return (a, b) -> a.compareTo(b) == 0;
        }
        else if(operator.equals("!=")){
            return (a, b) -> a.compareTo(b) != 0;
        }
        else return (a, b) -> false;
    }
}
