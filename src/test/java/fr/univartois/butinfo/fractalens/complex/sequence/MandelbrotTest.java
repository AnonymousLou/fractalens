package fr.univartois.butinfo.fractalens.complex.sequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.univartois.butinfo.fractalens.complex.Complex;
import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.fractalens.complex.IComplex;

class MandelbrotTest {

    /**
     * Creates a new complex number.
     *
     * @param realPart The real part of the complex number.
     * @param imaginaryPart The imaginary part of the complex number.
     *
     * @return The created complex number.
     */
    private static IComplex createComplex(double realPart, double imaginaryPart) {
        return new Complex(realPart, imaginaryPart);
    }

    /**
     * Creates a new sequence implementing Julia's sequence.
     *
     * @param first The first term of the sequence.
     * @param constant The constant number in the definition of the considered Julia's
     *        sequence.
     * @param nbTerms The maximum number of terms to compute.
     *
     * @return The created Julia's sequence.
     */
    private static IComplexSequence createMandelbrotSequence(IComplex first, IComplex constant,
                                                             int nbTerms, int power) {
        return new Mandelbrot(constant, first, nbTerms, power);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#computeNext(fr.univartois.butinfo.fractalens.complex.IComplex)}.
     */
    @Test
    void testComputeNext() {
        IComplex z0 = createComplex(0.5, 0);
        IComplex c = createComplex(0, 0);
        IComplexSequence mandelbrot = createMandelbrotSequence(z0, c, 50, 2);

        IComplex z1 = createComplex(0.75, 0);        // 0.5² + 0.5
        assertEquals(z1, mandelbrot.computeNext(z0));

        IComplex z2 = createComplex(1.0625, 0);      // 0.75² + 0.5
        assertEquals(z2, mandelbrot.computeNext(z1));

        IComplex z3 = createComplex(1.62890625, 0);  // 1.0625² + 0.5
        assertEquals(z3, mandelbrot.computeNext(z2));
    }

    @Test
    void testComputeNextWithPowerThree() {
        IComplex z0 = createComplex(0.5, 0);
        IComplex c = createComplex(0, 0);
        IComplexSequence mandelbrot = createMandelbrotSequence(z0, c, 50, 3);

        IComplex z1 = createComplex(0.625, 0);       // 0.5³ + 0.5
        assertEquals(z1, mandelbrot.computeNext(z0));

        IComplex z2 = createComplex(0.744140625, 0); // 0.625³ + 0.5
        assertEquals(z2, mandelbrot.computeNext(z1));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#iterator()}
     * when the sequence converges.
     */
    @Test
    void testIteratorOnConvergence() {
        IComplex z0 = createComplex(-1, 0);          // suite : -1, 0, -1, 0...
        IComplex c = createComplex(0, 0);
        int nbTerms = 50;

        IComplexSequence mandelbrot = createMandelbrotSequence(z0, c, nbTerms, 2);
        int nbIterations = 0;

        for (var _ : mandelbrot) {
            nbIterations++;
        }

        assertEquals(nbTerms, nbIterations);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#iterator()}
     * when the sequence diverges.
     */
    @Test
    void testIteratorOnDivergence() {
        IComplex z0 = createComplex(2, 0);           // suite : 2, 6, 38...
        IComplex c = createComplex(0, 0);
        int nbTerms = 50;

        IComplexSequence mandelbrot = createMandelbrotSequence(z0, c, nbTerms, 2);
        int nbIterations = 0;

        for (var _ : mandelbrot) {
            nbIterations++;
        }

        assertTrue(nbIterations < nbTerms);
    }
}
