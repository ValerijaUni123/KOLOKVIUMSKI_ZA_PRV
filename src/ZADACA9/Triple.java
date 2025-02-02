package ZADACA9;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Triple <T extends Number>{
    private List<T> list;
    public Triple(T a, T b, T c){
        list = new ArrayList<T>();
        list.add(a);
        list.add(b);
        list.add(c);
    }

    public double max(){
        return list.stream().mapToDouble(t -> t.doubleValue()).max().getAsDouble();
    }
    public double avarage(){
        return list.stream().mapToDouble(t -> t.doubleValue()).average().getAsDouble();
    }
    public void sort(){
        list = list.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f", list.get(0).doubleValue(), list.get(1).doubleValue(), list.get(2).doubleValue());
    }
}
