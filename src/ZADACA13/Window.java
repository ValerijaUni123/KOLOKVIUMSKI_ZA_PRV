package ZADACA13;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Window {
    private String name;
    private Map<Integer, Component> map;

    public Window(String name){
        this.name = name;
        this.map = new TreeMap<>();
    }

    public void addComponent(int position, Component component) throws InvalidPositionException {
        if(map.containsKey(position)) throw new InvalidPositionException(position);
        map.put(position, component);
    }

    public void changeColor(int weight, String color){
        for(Component component : map.values()){
            changeColorRecursive(weight, color, component);
        }
    }

    public void changeColorRecursive(int weight, String color, Component component){
        if(component.getWeight() < weight){
            component.setColor(color);
        }
        for(Component c : component.getInnerComponents()){
            changeColorRecursive(weight, color, c);
        }
    }
    public void swichComponents(int pos1, int pos2){
        Component component1 = map.get(pos1);
        Component component2 = map.get(pos2);

        map.put(pos1, component2);
        map.put(pos2, component1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WINDOW ").append(name).append("\n");

        map.forEach((k, v) -> stringBuilder.append(String.format("%d:%s", k, buildString(v, 0))));
        return stringBuilder.toString();
    }

    public String buildString(Component component, int level){
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<level*3;i++){
            str.append("-");
        }

        sb.append(String.format("%s%s\n", str, component));

        for(Component c : component.getInnerComponents()){
            sb.append(buildString(c, level+1));
        }
        return sb.toString();
    }


}
