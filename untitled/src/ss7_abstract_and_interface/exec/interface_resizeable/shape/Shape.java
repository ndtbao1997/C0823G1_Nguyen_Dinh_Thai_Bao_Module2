package ss7_abstract_and_interface.exec.interface_resizeable.shape;

import ss7_abstract_and_interface.exec.interface_resizeable.resizeable.Resizeable;

public abstract class Shape implements Resizeable {
    private double percent;
    public abstract double getArea();
    public abstract double getPerimeter();

    public void resize(double percent) {
        this.percent = percent;
    }

    @Override
    public double resizeShape() {
        return getArea()*(percent+1);
    }
}
