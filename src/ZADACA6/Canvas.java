package ZADACA6;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private final List<Shape> shapes;

    public Canvas() {
        shapes = new ArrayList<Shape>();
    }


    public void add(String id, Color color, float radius){
        addShape(new Circle(id, color, radius));
    }

    public void add(String id, Color color, float width, float height){
        addShape(new Rectangle(id, color, width, height));
    }

    public void addShape(Shape s){
        if(shapes.isEmpty()){
            shapes.add(s);
            return;
        }
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).weight() < s.weight()){
                shapes.add(i, s);
                return;
            }
        }
        shapes.add(s);

    }
    public void scale(String id, float scaleFactor){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).getId().equals(id)){

                Shape s = shapes.get(i);

                shapes.remove(s);
                s.scale(scaleFactor);
                addShape(s);

                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Shape s : shapes){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
