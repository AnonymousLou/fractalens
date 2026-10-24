package fr.univartois.butinfo.fractalens.complex.img.color;

import fr.univartois.butinfo.fractalens.image.color.ColoredFixe;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link ColoredFixe}.
 */
class ColoredFixeTest {
    /**
     * Tests that iteration 0 returns the first color in the palette.
     */
    @Test
    void testColoredDotFirstColor() {
        List<Color> testColors = List.of(Color.RED, Color.GREEN, Color.BLUE);
        ColoredFixe palette = new ColoredFixe(testColors);

        Color result = palette.coloredDot(0, 100);

        assertEquals(Color.RED, result);
    }

    /**
     * Tests intermediate iteration color mapping.
     */
    @Test
    void testColoredDotIntermediateColor() {
        List<Color> testColors = List.of(Color.RED, Color.GREEN, Color.BLUE);
        ColoredFixe palette = new ColoredFixe(testColors);

        Color result = palette.coloredDot(50, 100);

        assertEquals(Color.GREEN, result);
    }

    /**
     * Tests edge case right before max iterations to verify index boundary safety.
     */
    @Test
    void testColoredDotNearMaxIterations() {
        List<Color> testColors = List.of(Color.RED, Color.GREEN, Color.BLUE);
        ColoredFixe palette = new ColoredFixe(testColors);

        Color result = palette.coloredDot(99, 100);

        assertEquals(Color.BLUE, result);
    }
}
