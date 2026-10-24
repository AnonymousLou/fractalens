package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.function.BiFunction;

/**
 * Enumeration of the available complex sequences used to generate fractals.
 * Each constant provides a factory to instantiate the corresponding sequence.
 *
 * @author Tom Deleau
 *
 * @version 1.0
 */
public enum EnumSequence {

    /**
     * The classic Mandelbrot sequence.
     */
    MANDELBROT((pixel, max) -> new Mandelbrot(pixel, pixel, max, 2)),

    /**
     * A generalized Julia sequence using a predefined constant and power.
     */
    GENERALIZED_JULIA((pixel, max) -> {
        IComplex c = new Complex(0.285, 0.01);
        return new GeneralizedJulia(c, pixel, max, 3);
    }),

    /**
     * A generalized Mandelbrot sequence using a predefined power.
     */
    GENERALIZED_MANDELBROT((pixel, max) -> new Mandelbrot(pixel, pixel, max, 3)),

    /**
     * The classic Burning Ship sequence.
     */
    BURNING_SHIP((pixel, max) -> new BurningShipSequence(pixel, new Complex(0, 0), max)),

    /**
     * A generalized Burning Ship sequence utilizing a higher power.
     */
    GENERALIZED_BURNING_SHIP((pixel, max) -> new GeneralComplexSequence(
            (prev, initial) -> {
                double absReal = Math.abs(prev.getRealPart());
                double absImag = Math.abs(prev.getImaginaryPart());
                return new Complex(absReal, absImag).power(3).add(pixel);
            },
            new Complex(0, 0),
            max
    )),

    /**
     * The classic Tricorn (or Mandelbar) sequence.
     */
    TRICORN((pixel, max) -> new GeneralComplexSequence(
            (prev, initial) -> prev.conjugate().multiply(prev.conjugate()).add(pixel),
            new Complex(0, 0),
            max
    )),

    /**
     * A generalized Tricorn sequence utilizing a higher power.
     */
    GENERALIZED_TRICORN((pixel, max) -> new GeneralComplexSequence(
            (prev, initial) -> prev.conjugate().power(3).add(pixel),
            new Complex(0, 0),
            max
    ));

    /**
     * The factory function responsible for creating the complex sequence instance.
     */
    private final BiFunction<IComplex, Integer, IComplexSequence> factory;

    /**
     * Constructs a new sequence enumeration constant.
     *
     * @param factory The function used to generate the sequence.
     */
    EnumSequence(BiFunction<IComplex, Integer, IComplexSequence> factory) {
        this.factory = factory;
    }

    /**
     * Creates a new instance of the complex sequence for a given pixel.
     *
     * @param pixel         The complex number representing the current pixel's position.
     * @param maxIterations The maximum number of iterations allowed for the sequence.
     * @return A new instance of {@link IComplexSequence}.
     */
    public IComplexSequence create(IComplex pixel, int maxIterations) {
        return factory.apply(pixel, maxIterations);
    }
}
