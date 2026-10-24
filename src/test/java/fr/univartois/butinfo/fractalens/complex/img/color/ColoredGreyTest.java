package fr.univartois.butinfo.fractalens.complex.img.color;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.univartois.butinfo.fractalens.image.color.ColoredGrey;
import org.junit.jupiter.api.Test;
import java.awt.Color;

/**
 * The {@code ColoredTest} class tests the implementation of {@link ColoredGrey}.
 *
 * @author Eva Nys
 * @version 0.1.0
 */
class ColoredGreyTest {

    /**
     * Tests the color generation at zero iterations.
     */
    @Test
    void testColoredDot() {
        ColoredGrey coloredGrey = new ColoredGrey();
        Color color = coloredGrey.coloredDot(0, 100);
        assertEquals(255, color.getRed());
    }
}
