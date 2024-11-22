package ZADACA5;


public class MinMax <T extends Comparable<T>>{
    private T min;
    private T max;

    private int updates;
    private int maxCount;
    private int minCount;

    public MinMax(){
        min = null;
        max = null;

        updates = 0;
        maxCount = 0;
        minCount = 0;
    }

    public void update(T element){
        if(updates == 0){
            min = element;
            max = element;
        }
        if(element.compareTo(min) < 0){
            min = element;
            minCount = 1;
        }
        else if(element.compareTo(min) == 0){
            minCount++;
        }
        if(element.compareTo(max) > 0){
            max = element;
            maxCount=1;
        }
        else if(element.compareTo(max) == 0){
            maxCount++;
        }
        updates++;
    }

    public T min(){
        return min;
    }
    public T max(){
        return max;
    }

    @Override
    public String toString() {
        return min + " " + max + " " + (updates - minCount - maxCount) + "\n";
    }
}
