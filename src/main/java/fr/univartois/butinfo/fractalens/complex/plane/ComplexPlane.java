package fr.univartois.butinfo.fractalens.complex.plane;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

/**
 * The {@code ComplexPlane} class provides a basic implementation of the {@link IComplexPlane} interface,
 * allowing the pixel coordinates of an image to be associated with points in the complex plane.
 *
 * @author Halipré Hugo
 *
 * @version 0.1.0
 */
public class ComplexPlane implements IComplexPlane {

    /**
     * The width of the image in pixels.
     */
    private final int width;

    /**
     * The height of the image in pixels.
     */
    private final int height;

    /**
     * Construct a new complex plan with the specified dimensions.
     *
     * @param width The width of the image in pixels.
     * @param height The height of the image in pixels.
     */
    public ComplexPlane(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Determine the complex number corresponding to the position of a pixel in the image.
     *
     * @param row The pixel line in the image (ordinate, from top to bottom).
     * @param column The column of the pixel in the image (abscissa, from left to right).
     *
     * @return the complex number corresponding to the given position.
     */
    @Override
    public IComplex asComplex(int row, int column) {
        double realPart = column - (width / 2.0);
        double imaginaryPart = (height / 2.0) - row;
        return new Complex(realPart, imaginaryPart);
    }
}
