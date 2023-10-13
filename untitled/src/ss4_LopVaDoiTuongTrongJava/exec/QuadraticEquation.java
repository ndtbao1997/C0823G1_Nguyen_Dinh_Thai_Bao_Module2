package ss4_LopVaDoiTuongTrongJava.exec;

import java.util.Scanner;

public class QuadraticEquation {
    public double a;
    public double b;
    public double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double setA(double a) {
        return this.a = a;
    }

    public double setB(double b) {
        return this.b = b;
    }

    public double setC(double c) {
        return this.c = c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (0 - this.b + Math.pow(getDiscriminant(), 0.5)) / 2 * this.a;
    }

    public double getRoot2() {
        double squareRoot1 = Math.pow((Math.pow(this.b, 2) - 4 * this.a * this.c), 0.5);
        return (0 - this.b - squareRoot1) / 2 * this.a;
    }
}
