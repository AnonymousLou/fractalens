package fr.univartois.butinfo.fractalens.complex.sequence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

/**
 * The {@code GeneralComplexSequenceTest} class tests the implementation of
 * {@link GeneralComplexSequence}.
 *
 * @author Your Name
 * @version 0.1.0
 */
class GeneralComplexSequenceTest {

    /**
     * The maximum number of iterations used in the tests.
     */
    private static final int MAX = 50;

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
     * Creates the Mandelbrot sequence f(z) = z^2 + z0 for the given first term.
     *
     * @param z0 The first term of the sequence.
     * @param max The maximum number of iterations.
     *
     * @return The created sequence.
     */
    private static GeneralComplexSequence createMandelbrot(IComplex z0, int max) {
        return new GeneralComplexSequence((z, start) -> z.multiply(z).add(start), z0, max);
    }

    /**
     * Counts the terms produced by a sequence.
     *
     * @param sequence The sequence to iterate over.
     *
     * @return The number of terms of the sequence.
     */
    private static int count(IComplexSequence sequence) {
        int nbTerms = 0;
        for (var _ : sequence) {
            nbTerms++;
        }
        return nbTerms;
    }

    /**
     * Test method for {@link GeneralComplexSequence#computeNext(IComplex)}
     * with a function using z0.
     */
    @Test
    void testComputeNextUsingZ0() {
        GeneralComplexSequence sequence = createMandelbrot(createComplex(1, 1), MAX);
        assertEquals(createComplex(1, 3), sequence.computeNext(createComplex(1, 1)));
    }

    /**
     * Test method for {@link GeneralComplexSequence#computeNext(IComplex)}
     * with a function ignoring z0 (Julia-like sequence).
     */
    @Test
    void testComputeNextIgnoringZ0() {
        IComplex c = createComplex(-0.4, 0.6);
        GeneralComplexSequence sequence = new GeneralComplexSequence((z, start) -> z.multiply(z).add(c), createComplex(5, 5), MAX);
        assertEquals(c, sequence.computeNext(createComplex(0, 0)));
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * The first term of the sequence must be z0.
     */
    @Test
    void testFirstTermIsZ0() {
        IComplex z0 = createComplex(0.1, 0.2);
        assertEquals(z0, createMandelbrot(z0, MAX).iterator().next());
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * A sequence that does not diverge stops at the maximum number of iterations.
     */
    @Test
    void testStopsAtMaxIterations() {
        assertEquals(MAX, count(createMandelbrot(createComplex(0, 0), MAX)));
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * A sequence whose first term already diverges has no term.
     */
    @Test
    void testDivergesImmediately() {
        assertEquals(0, count(createMandelbrot(createComplex(2, 2), MAX)));
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * A sequence that diverges after a few iterations stops before the maximum.
     */
    @Test
    void testDivergesAfterSomeIterations() {
        assertEquals(2, count(createMandelbrot(createComplex(1, 0), MAX)));
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * Once the last term has been read, there is no next term.
     */
    @Test
    void testHasNextAfterLastTerm() {
        var iterator = createMandelbrot(createComplex(0, 0), 3).iterator();
        assertEquals(true, iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        assertEquals(false, iterator.hasNext());
    }

    /**
     * Test method for {@link GeneralComplexSequence#iterator()}.
     * Iterating twice over the same sequence gives the same result.
     */
    @Test
    void testIteratorIsReusable() {
        GeneralComplexSequence sequence = createMandelbrot(createComplex(0.3, 0.2), MAX);
        assertEquals(count(sequence), count(sequence));
    }

    /**
     * Test that {@link GeneralComplexSequence} gives the same number of terms as
     * {@link JuliaSequence} when it uses the same formula.
     */
    @Test
    void testSameAsJuliaSequence() {
        IComplex c = createComplex(-0.4, 0.6);
        IComplex[] startingPoints = {
                createComplex(0, 0), createComplex(0.5, 0.5), createComplex(-1, 0.3),
                createComplex(1.5, -1.2), createComplex(0.1, 0.6)
        };
        for (IComplex z0 : startingPoints) {
            GeneralComplexSequence general = new GeneralComplexSequence((z, start) -> z.multiply(z).add(c), z0, 100);
            assertEquals(count(new JuliaSequence(c, z0, 100)), count(general));
        }
    }
}
