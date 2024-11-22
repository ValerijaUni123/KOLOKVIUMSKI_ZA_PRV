package ZADACA6;

public class Circle extends Shape{
    private float radius;

    public Circle(String id, Color color, float radius) {
        super(id, color, Type.CIRCLE);
        this.radius = radius;
    }

    @Override
    public void scale(float scaleFactor) {
        radius*=scaleFactor;
    }

    @Override
    public float weight() {
        return (float) Math.PI*radius*radius;
    }
}
