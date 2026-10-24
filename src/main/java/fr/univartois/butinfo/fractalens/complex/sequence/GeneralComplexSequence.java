package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

/**
 * The {@code GeneralComplexSequence} class is a sequence of complex numbers
 *
 * @author Hugo Halipré
 * @version 1.0
 */
public class GeneralComplexSequence implements IComplexSequence {

    /**
     *The binary function used
     */
    private final BinaryOperator<IComplex> function;
    /**
     *The initial value of the sequence.
     */
    private final IComplex z0;
    /**
     *The maximum number of iterations for this sequence.
     */
    private final int max;

    /**
     * Construct a new instance of {@code GeneralComplexSequence} with the specified dimensions.
     *
     * @param function The binary function used
     * @param z0 The initial value of the sequence.
     * @param max The maximum number of iterations for this sequence.
     */
    public GeneralComplexSequence(BinaryOperator<IComplex> function, IComplex z0, int max) {
        this.function = function;
        this.z0 = z0;
        this.max = max;
    }

    /**
     * Calculate the next term of the sequence by applying the binary function
     *
     * @param previous The previous value in the sequence.
     *
     * @return The following term calculated.
     */
    @Override
    public IComplex computeNext(IComplex previous) {
        return function.apply(previous, z0);
    }

    /**
     * explore the different terms of the sequence
     *
     * @return A new iterator on the values of the sequence, starting at the initial value
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, max);
    }

}
