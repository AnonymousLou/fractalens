package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;

/**
 * The {@code GeneralizedJulia} class is a sequence of complex numbers
 *
 * @author Eva Nys
 * @version 1.0
 */
public class GeneralizedJulia implements IComplexSequence {

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
    private final int p;


    /**
     * Construct a new instance of {@code GeneralizedJulia} with the specified dimensions.
     *
     * @param c The constant complex number
     * @param z0 The initial value of the sequence.
     * @param maxIterations The maximum number of iterations for this sequence.
     * @param p the exponent used for power
     */
    public GeneralizedJulia(IComplex c, IComplex z0, int maxIterations, int p) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
        this.p = p;
    }

    /**
     * Calculate the next term of the sequence using the formula z^p+c
     *
     * @param previous The previous value in the sequence.
     *
     * @return The following term calculated.
     */
    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.power(p).add(c);
    }

    /**
     * explore the different terms of the complex number sequence
     *
     * @return A new iterator on the values of the sequence, starting at the initial value
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }
}
