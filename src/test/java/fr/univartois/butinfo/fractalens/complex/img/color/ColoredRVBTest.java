package fr.univartois.butinfo.fractalens.complex.img.color;

import fr.univartois.butinfo.fractalens.image.color.ColoredRVB;
import fr.univartois.butinfo.fractalens.image.color.IColor;
import org.junit.jupiter.api.Test;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link ColoredRVB} decorator.
 */
 class ColoredRVBTest {

    /**
     * Tests filtering to keep only the red channel.
     */
    @Test
    void testColoredDotOnlyRed() {
        IColor basePalette = (iteration, max) -> new Color(255, 255, 255);

        ColoredRVB redOnly = new ColoredRVB(basePalette, 1.0, 0.0, 0.0);

        Color result = redOnly.coloredDot(10, 100);

        assertEquals(255, result.getRed());
        assertEquals(0, result.getGreen());
        assertEquals(0, result.getBlue());
    }

    /**
     * Tests scaling RGB components with custom factors.
     */
    @Test
    void testColoredDotWithScaling() {
        IColor basePalette = (iteration, max) -> new Color(100, 150, 200);

        ColoredRVB scaled = new ColoredRVB(basePalette, 0.5, 0.2, 0.0);

        Color result = scaled.coloredDot(5, 50);
        assertEquals(50, result.getRed());
        assertEquals(30, result.getGreen());
        assertEquals(0, result.getBlue());
    }
}
