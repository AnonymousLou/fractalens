package fr.univartois.butinfo.fractalens.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.TranslateComplexPlane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link TranslateComplexPlane} class including edge cases.
 *
 * @author Hugo Halipré
 * @version 1.0
 */
class TranslateComplexPlaneTest {
    /** The base complex plane used for testing translations. */
    private IComplexPlane basePlane;
    /**
     * Sets up the test environment before each test execution.
     */
    @BeforeEach
    void setUp() {
        basePlane = new ComplexPlane(800, 600);
    }
    /**
     * Test method for verifying standard translation of a complex plane.
     */
    @Test
    void testStandardTranslation() {
        IComplex complexNumber = new Complex(0.1, 0.6);
        IComplexPlane translatedPlane = new TranslateComplexPlane(basePlane, complexNumber);
        IComplex base = basePlane.asComplex(100, 200);
        IComplex result = translatedPlane.asComplex(100, 200);
        assertNotNull(result);
        assertEquals(base.getRealPart() + complexNumber.getRealPart(), result.getRealPart(), 1e-9);
        assertEquals(base.getImaginaryPart() + complexNumber.getImaginaryPart(), result.getImaginaryPart(), 1e-9);
    }
    /**
     * Test method for verifying translation with a zero offset complex number.
     */
    @Test
    void testZeroTranslation() {
        IComplex zerocomplexNumber = new Complex(0, 0);
        IComplexPlane translatedPlane = new TranslateComplexPlane(basePlane, zerocomplexNumber);
        IComplex base = basePlane.asComplex(0, 0);
        IComplex result = translatedPlane.asComplex(0, 0);
        assertEquals(base.getRealPart(), result.getRealPart(), 1e-9);
        assertEquals(base.getImaginaryPart(), result.getImaginaryPart(), 1e-9);
    }
    /**
     * Test method for verifying translation with large negative coordinate values.
     */
    @Test
    void testNegativeAndLargeTranslation() {
        IComplex largeNegativeComplexNumber = new Complex(-1000.5, -2000.25);
        IComplexPlane translatedPlane = new TranslateComplexPlane(basePlane, largeNegativeComplexNumber);
        IComplex base = basePlane.asComplex(300, 400);
        IComplex result = translatedPlane.asComplex(300, 400);
        assertEquals(base.getRealPart() - 1000.5, result.getRealPart(), 1e-9);
        assertEquals(base.getImaginaryPart() - 2000.25, result.getImaginaryPart(), 1e-9);
    }
    /**
     * Test method for verifying correct translation behavior at the image boundaries.
     */
    @Test
    void testImageBoundaries() {
        IComplex complexNumber = new Complex(0.5, -0.5);
        IComplexPlane translatedPlane = new TranslateComplexPlane(basePlane, complexNumber);
        IComplex topLeftBase = basePlane.asComplex(0, 0);
        IComplex topLeftResult = translatedPlane.asComplex(0, 0);
        assertEquals(topLeftBase.getRealPart() + 0.5, topLeftResult.getRealPart(), 1e-9);
        assertEquals(topLeftBase.getImaginaryPart() - 0.5, topLeftResult.getImaginaryPart(), 1e-9);
        IComplex bottomRightBase = basePlane.asComplex(599, 799);
        IComplex bottomRightResult = translatedPlane.asComplex(599, 799);
        assertEquals(bottomRightBase.getRealPart() + 0.5, bottomRightResult.getRealPart(), 1e-9);
        assertEquals(bottomRightBase.getImaginaryPart() - 0.5, bottomRightResult.getImaginaryPart(), 1e-9);
    }
}
