package fr.univartois.butinfo.fractalens.complex;

import java.util.Objects;

/**
 * The {@code Complex} class represents an immutable complex number with real and imaginary parts.
 *
 * @author Hugo Halipré, Tom Deleau
 *
 * @version 0.1.0
 */
public class Complex implements IComplex {

    /**
     * The real part of the complex number.
     */
    private final double a;

    /**
     * The imaginary part of the complex number.
     */
    private final double b;

    /**
     * Constructs a new {@code Complex} number with the specified real and imaginary parts.
     *
     * @param a The real part of the complex number.
     * @param b The imaginary part of the complex number.
     */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Gives the real part of this complex number.
     *
     * @return The real part of this complex number.
     */
    @Override
    public double getRealPart() {
        return a;
    }

    /**
     * Gives the imaginary part of this complex number.
     *
     * @return The imaginary part of this complex number.
     */
    @Override
    public double getImaginaryPart() {
        return b;
    }

    /**
     * Gives the modulus of this complex number.
     *
     * @return The modulus of this complex number.
     */
    @Override
    public double abs() {
        double a1 = this.getRealPart();
        double b1 = this.getImaginaryPart();
        return Math.sqrt(a1 * a1 + b1 * b1);
    }

    /**
     * Gives the opposite of this complex number.
     *
     * @return The opposite of this complex number.
     */
    @Override
    public IComplex negate() {
        double a1 = this.getRealPart();
        double b1 = this.getImaginaryPart();
        return new Complex(-a1, -b1);
    }

    /**
     * Gives the conjugate of this complex number.
     *
     * @return The conjugate of this complex number.
     */
    @Override
    public IComplex conjugate() {
        double a1 = this.getRealPart();
        double b1 = this.getImaginaryPart();
        return new Complex(a1, -b1);
    }

    /**
     * Adds this complex number to another one.
     *
     * @param other The complex number to add to this one.
     *
     * @return The result of {@code this + other}.
     */
    @Override
    public IComplex add(IComplex other) {
        double a1 = this.getRealPart();
        double a2 = other.getRealPart();
        double b1 = this.getImaginaryPart();
        double b2 = other.getImaginaryPart();
        double resA = a1 + a2;
        double resB = b1 + b2;
        return new Complex(resA, resB);
    }

    /**
     * Subtracts a complex number from this one.
     *
     * @param other The complex number to subtract from this one.
     *
     * @return The result of {@code this - other}.
     */
    @Override
    public IComplex subtract(IComplex other) {
        double a1 = this.getRealPart();
        double a2 = other.getRealPart();
        double b1 = this.getImaginaryPart();
        double b2 = other.getImaginaryPart();
        double resA = a1 - a2;
        double resB = b1 - b2;
        return new Complex(resA, resB);
    }

    /**
     * Multiplies this complex number by a real value.
     *
     * @param value The value by which to multiply this number.
     *
     * @return The result of {@code this * value}.
     */
    @Override
    public IComplex multiply(double value) {
        double a1 = this.getRealPart();
        double b1 = this.getImaginaryPart();
        double resA = value * a1;
        double resB = value * b1;
        return new Complex(resA, resB);
    }

    /**
     * Multiplies this complex number by another one.
     *
     * @param other The complex number to multiply this one with.
     *
     * @return The result of {@code this * other}.
     */
    @Override
    public IComplex multiply(IComplex other) {
        double a1 = this.getRealPart();
        double a2 = other.getRealPart();
        double b1 = this.getImaginaryPart();
        double b2 = other.getImaginaryPart();
        double resA = (a1 * a2 - b1 * b2);
        double resB = (a2 * b1 + a1 * b2);
        return new Complex(resA, resB);
    }

    /**
     * Divides this complex number by another one.
     *
     * @param other The complex number to divide this one by.
     *
     * @return The result of {@code this / other}.
     */
    @Override
    public IComplex divide(IComplex other) {
        double a1 = this.getRealPart();
        double a2 = other.getRealPart();
        double b1 = this.getImaginaryPart();
        double b2 = other.getImaginaryPart();
        double denominator = a2 * a2 + b2 * b2;
        double resA = (a1 * a2 + b1 * b2) / denominator;
        double resB = (a2 * b1 - a1 * b2) / denominator;
        return new Complex(resA, resB);
    }

    /**
     * Checks whether this complex number is equal to another object.
     *
     * @param o The object to compare with this complex number.
     *
     * @return {@code true} if the given object is a complex number with equal real and imaginary parts;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Complex complex = (Complex) o;
        return a == complex.a && b == complex.b;
    }

    /**
     * Returns a hash code value for this complex number.
     *
     * @return The hash code of this complex number.
     */
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    /**
     * Returns a string representation of this complex number in standard algebraic notation {@code a + bi}.
     *
     * @return A string representing this complex number.
     */
    @Override
    public String toString() {
        if (b < 0) {
            return a + " - " + -b + "i";
        }
        return a + " + " + b + "i";
    }


    /**
     * raise to the power a value
     *
     * @param power The complex number to power
     *
     * @return The result of {@code this / other}.
     */
    @Override
    public IComplex power(int power) {
        IComplex test = new Complex(1, 0);
        for (int i = 0; i < power; i++) {
            test = test.multiply(this);
        }
        return test;
    }
}