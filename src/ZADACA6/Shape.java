package ZADACA6;

public abstract class Shape implements Scalable, Stackable, Comparable<Shape>{
    private String id;
    private Color color;
    private Type type;

    public Shape(String id, Color color, Type type) {
        this.id = id;
        this.color = color;
        this.type = type;
    }
    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Shape o) {
        return Float.compare(weight(), o.weight());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(type == Type.CIRCLE){
            stringBuilder.append("C: ");
        }
        else if(type == Type.RECTANGLE){
            stringBuilder.append("R: ");
        }
        stringBuilder.append(String.format("%-5s%10s%10.2f\n", id, color.toString(), weight()));
        return stringBuilder.toString();
    }
}
