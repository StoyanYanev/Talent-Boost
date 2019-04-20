package Interfaces.Figures;

public class Rectangle implements Shape {
    private final float a;
    private final float b;

    Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public float getArea() {
        return this.a * this.b;
    }
}