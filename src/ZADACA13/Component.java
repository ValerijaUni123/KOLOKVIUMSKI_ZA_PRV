package ZADACA13;

import java.util.Set;
import java.util.TreeSet;

public class Component implements Comparable<Component>{
    private String color;
    private int weight;
    private Set<Component> innerComponents;

    public Component(String color, int weight){
        this.color = color;
        this.weight = weight;
        this.innerComponents = new TreeSet<Component>();
    }

    public void addComponent(Component component){
        innerComponents.add(component);
    }

    @Override
    public int compareTo(Component o) {
        if(this.weight != o.weight){
            return Integer.compare(this.weight, o.weight);
        }
        return this.color.compareTo(o.color);
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public Set<Component> getInnerComponents() {
        return innerComponents;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setInnerComponents(Set<Component> innerComponents) {
        this.innerComponents = innerComponents;
    }

    @Override
    public String toString() {
        return String.format("%d:%s", weight, color);
    }
}
