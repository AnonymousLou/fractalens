package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;
import java.util.Iterator;

/**
 * Implementation of the Julia set for the representation of its fractal.
 * This class generates the sequence of complex numbers used to determine
 * whether a given initial point belongs to the Julia set.
 *
 * @author The Fractalens Team, Louis Dunocq, Eva Nys
 * @version 1.0
 */
public class JuliaSequence implements IComplexSequence {

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
     * Constructs a new Julia sequence using a constant complex number,
     * an initial value, and a maximum iteration limit.
     *
     * @param c The fixed complex constant characterizing the Julia set
     * @param z0 The initial complex number from which the sequence is evaluated
     * @param maxIterations The maximum number of iterations allowed for the sequence
     */
    public JuliaSequence(IComplex c, IComplex z0, int maxIterations) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
    }

    /**
     * Computes the next term in the Julia sequence based on the previous term.
     * The formula used is $z_{n+1} = z_n^2 + c$.
     *
     * @param previous The previous complex number in the sequence
     * @return The newly computed complex number
     */
    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.multiply(previous).add(c);
    }

    /**
     * Returns an iterator over the elements of this complex sequence.
     *
     * @return An {@link Iterator} of {@link IComplex} representing the sequence values
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }
}