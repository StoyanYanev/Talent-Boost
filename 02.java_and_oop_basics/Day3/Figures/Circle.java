package Interfaces.Figures;

final public class Circle implements Shape {
    private final float r;

    Circle(float r) {
        this.r = r;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * this.r * this.r);
    }
}