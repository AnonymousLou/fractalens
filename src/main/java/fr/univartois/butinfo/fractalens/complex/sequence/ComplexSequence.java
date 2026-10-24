package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Independent iterator for traversing the terms of a complex sequence.
 *
 * @author UnivArtois, Louis Dunocq, Hugo Halipré
 * @version 1.0
 */
public class ComplexSequence implements Iterator<IComplex> {

    /**
     * The sequence used to calculate the terms.
     */
    private final IComplexSequence sequence;

    /**
     * The maximum number of iterations to perform.
     */
    private final int maxIterations;

    /**
     * The current complex term in the sequence.
     */
    private IComplex current;

    /**
     * The number of iterations already performed.
     */
    private int nbIterations;

    /**
     * Construct a new instance of {@code ComplexSequence} with the specified dimensions.
     *
     * @param sequence      The complex sequence to navigate.
     * @param initialValue  The initial complex number (z0).
     * @param maxIterations The maximum number of permitted iterations.
     */
    public ComplexSequence(IComplexSequence sequence, IComplex initialValue, int maxIterations) {
        this.sequence = sequence;
        this.current = initialValue;
        this.maxIterations = maxIterations;
        this.nbIterations = 0;
    }

    /**
     *Check if there are any more elements to go through in the rest of the process.
     *
     * @return true if there is a following element, or false otherwise.
     */
    @Override
    public boolean hasNext() {
        return (nbIterations < maxIterations) && (current.abs() <= 2.0);
    }

    /**
     *The current complex number of the sequence
     *
     * @throw NoSuchElementException if the iteration limit is reached or if the sequence diverges.
     *
     * @return The current term of the sequence.
     */
    @Override
    public IComplex next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Iteration limit reached or divergent sequence.");
        }
        IComplex tmp = current;
        current = sequence.computeNext(current);
        nbIterations++;

        return tmp;
    }
}