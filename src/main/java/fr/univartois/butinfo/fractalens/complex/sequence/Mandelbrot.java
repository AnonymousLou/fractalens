package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;
import java.util.Iterator;

/**
 * Independent iterator for traversing the terms of a complex sequence.
 *
 * @author UnivArtois, Louis Dunocq
 * @version 1.0
 */
public class Mandelbrot implements IComplexSequence {

    /**
     *The constant complex number
     */
    private final IComplex c;
    /**
     *The initial value of the sequence.
     */
    private final IComplex z0;
    /**
     * The maximum number of iterations for this sequence.
     */
    private final int maxIterations;
    /**
     *the exponent used for power
     */
    private final int power;

    /**
     *
     * @param c The constant complex number
     * @param z0 The initial value of the sequence.
     * @param maxIterations The maximum number of iterations for this sequence.
     * @param power the exponent used for power
     */
    public Mandelbrot(IComplex c, IComplex z0, int maxIterations, int power) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
        this.power = power;
    }

    /**
     * Calculate the next term of the sequence using the formula z^p+z0
     *
     * @param previous The previous value in the sequence.
     *
     * @return The following term calculated.
     */
    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.power(power).add(z0);
    }

    /**
     * Returns an iterator over the elements of this complex sequence
     *
     * @return An {@link Iterator} of {@link IComplex} representing the sequence values
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }

    public IComplex getC() {

        return c;
    }

}
