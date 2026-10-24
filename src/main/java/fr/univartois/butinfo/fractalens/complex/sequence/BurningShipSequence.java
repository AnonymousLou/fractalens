package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;

/**
 * The {@code BurningShipSequence} class allows you to zoom a image
 *
 * @author Tom Deleau
 *
 * @version 0.1.0
 */
public class BurningShipSequence implements IComplexSequence {
    /**
     *The complex number.
     */
    private final IComplex c;

    /**
     *The initial value of the sequence.
     */
    private final IComplex z0;

    /**
     *The maximum number of iterations for this sequence.
     */
    private final int maxIterations;

    /**
     *Construct a new instance of {@code BurningShipSequence} with the specified dimensions.
     *
     * @param c The complex number.
     * @param z0 The initial value of the sequence.
     * @param maxIterations The maximum number of iterations for this sequence.
     */
    public BurningShipSequence(IComplex c, IComplex z0, int maxIterations){
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
    }

    /**
     *Calculate the next term in the sequence using the specific Burning Ship formula.
     *
     * @param previous The previous value in the sequence.
     *
     * @return the next term calculated
     */
    @Override
    public IComplex computeNext(IComplex previous) {
        double absReal = Math.abs(previous.getRealPart());
        double absImag = Math.abs(previous.getImaginaryPart());
        IComplex absComplex = new Complex(absReal, absImag);
        return absComplex.multiply(absComplex).add(c);
    }

    /**
     *traverse the different terms of the sequence of complex numbers.
     *
     * @return a iterator
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }

}
