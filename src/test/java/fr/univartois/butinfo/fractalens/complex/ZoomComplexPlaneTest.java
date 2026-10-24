package fr.univartois.butinfo.fractalens.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.ZoomComplexPlane;
import org.junit.jupiter.api.Test;

/**
 * The {@code ZoomComplexPlaneTest} class tests the implementation of {@link ZoomComplexPlane}.
 *
 * @author Hugo Halipré
 * @version 0.1.0
 */
class ZoomComplexPlaneTest {

    /**
     * Tests that the zoom factor is correctly applied to complex coordinates.
     */
    @Test
    void testAsComplexWithZoom() {
        IComplexPlane basePlan = new ComplexPlane(800, 600);
        IComplexPlane zoomPlan = new ZoomComplexPlane(basePlan,0.004);
        IComplex expectedZoom = basePlan.asComplex(100, 200).multiply(0.004);
        assertEquals(expectedZoom, zoomPlan.asComplex(100, 200));
    }
}
