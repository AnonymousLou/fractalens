package fr.univartois.butinfo.fractalens.complex.plane;

import fr.univartois.butinfo.fractalens.complex.IComplex;

/**
 * Decorates an {@link IComplexPlane} by applying a translation
 * to the complex coordinates to change the center of the plane.
 *
 * @author Hugo Halipré
 * @version 1.0
 */
public class TranslateComplexPlane implements IComplexPlane {

    /**
     * The underlying complex plane to decorate.
     */
    private final IComplexPlane decorated;

    /**
     * The complex number representing the translation complexNumber (new center).
     */
    private final IComplex complexNumber;

    /**
     * Constructs a new {@code TranslateComplexPlane} decorator.
     *
     * @param decorated the base complex plane to decorate
     * @param complexNumber the complex number to add to every point on the plane
     */
    public TranslateComplexPlane(IComplexPlane decorated, IComplex complexNumber) {
        this.decorated = decorated;
        this.complexNumber = complexNumber;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        IComplex baseComplex = decorated.asComplex(row, column);
        return baseComplex.add(complexNumber);
    }
}
