package ZADACA6;

public class Rectangle extends Shape{
    private float width;
    private float height;

    public Rectangle(String id, Color color, float width, float height) {
        super(id, color, Type.RECTANGLE);
        this.width = width;
        this.height = height;
    }

    @Override
    public void scale(float scaleFactor) {
        width*=scaleFactor;
        height*=scaleFactor;
    }

    @Override
    public float weight() {
        return width*height;
    }
}
