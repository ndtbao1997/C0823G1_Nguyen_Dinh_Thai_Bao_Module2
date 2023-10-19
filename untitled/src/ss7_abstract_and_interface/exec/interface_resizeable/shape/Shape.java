package ss7_abstract_and_interface.exec.interface_resizeable.shape;

import ss7_abstract_and_interface.exec.interface_resizeable.resizeable.Resizeable;

public abstract class Shape implements Resizeable {
    public abstract double getArea();
    public abstract double getPerimeter();
}
