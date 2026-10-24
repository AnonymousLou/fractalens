package fr.univartois.butinfo.fractalens.complex.sequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.univartois.butinfo.fractalens.complex.Complex;
import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.fractalens.complex.IComplex;

class GeneralizedJuliaTest {

    /**
     * Creates a new complex number.
     *
     * @param realPart The real part of the complex number.
     * @param imaginaryPart The imaginary part of the complex number.
     * @return The created complex number.
     */
    private static IComplex createComplex(double realPart, double imaginaryPart) {
        return new Complex(realPart, imaginaryPart);
    }

    /**
     * Creates a new sequence implementing Generalized Julia's sequence.
     *
     * @param constant The constant number in the definition of the Generalized Julia's sequence.
     * @param first The first term of the sequence.
     * @param nbTerms The maximum number of terms to compute.
     * @param p The power exponent.
     * @return The created Generalized Julia's sequence.
     */
    private static IComplexSequence createGeneralizedJuliaSequence(IComplex constant, IComplex first, int nbTerms, int p) {
        return new GeneralizedJulia(constant, first, nbTerms, p);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#computeNext(fr.univartois.butinfo.fractalens.complex.IComplex)}.
     */
    @Test
    void testComputeNext() {
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(2, 0);
        int p = 3; // z^3 + c
        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, 50, p);

        // Formule : previous^3 + c -> (2)^3 + 0 = 8
        IComplex z1 = createComplex(8, 0);
        assertEquals(z1, julia.computeNext(z0));

        // (8)^3 + 0 = 512
        IComplex z2 = createComplex(512, 0);
        assertEquals(z2, julia.computeNext(z1));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#iterator()}
     * when the sequence converges.
     */
    @Test
    void testIteratorOnConvergence() {
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(0.5, 0); // Converge vers 0
        int nbTerms = 50;
        int p = 2;

        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, nbTerms, p);
        int nbIterations = 0;

        for (var _ : julia) {
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
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(2, 0); // Diverge
        int nbTerms = 50;
        int p = 2;

        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, nbTerms, p);
        int nbIterations = 0;

        for (var _ : julia) {
            nbIterations++;
        }

        assertTrue(nbIterations < nbTerms);
    }

}