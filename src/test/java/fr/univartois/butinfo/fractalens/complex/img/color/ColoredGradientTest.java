package fr.univartois.butinfo.fractalens.complex.img.color;

import fr.univartois.butinfo.fractalens.image.color.ColoredGradient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The {@code ColoredGradientTest} class tests the {@link ColoredGradient} class.
 *
 * @version 0.1.0
 */
class ColoredGradientTest {

    /** The gradient instance being tested. */
    private ColoredGradient gradient;
    /** The starting color of the gradient. */
    private Color startColor;
    /** The ending color of the gradient. */
    private Color endColor;

    /**
     * Sets up the test environment before each test execution.
     */
    @BeforeEach
    void setUp() {
        startColor = Color.BLACK;
        endColor = Color.WHITE;
        gradient = new ColoredGradient(startColor, endColor);
    }

    /**
     * Test method for {@link ColoredGradient#coloredDot(int, int)} at zero iteration.
     */
    @Test
    void testColoredDotAtZeroIteration() {
        Color result = gradient.coloredDot(0, 100);

        assertEquals(startColor.getRed(), result.getRed());
        assertEquals(startColor.getGreen(), result.getGreen());
        assertEquals(startColor.getBlue(), result.getBlue());
    }

    /**
     * Test method for {@link ColoredGradient#coloredDot(int, int)} at maximum iteration.
     */
    @Test
    void testColoredDotAtMaxIteration() {
        Color result = gradient.coloredDot(100, 100);

        assertEquals(endColor.getRed(), result.getRed());
        assertEquals(endColor.getGreen(), result.getGreen());
        assertEquals(endColor.getBlue(), result.getBlue());
    }

    /**
     * Test method for {@link ColoredGradient#coloredDot(int, int)} at half iteration.
     */
    @Test
    void testColoredDotAtHalfIteration() {
        Color result = gradient.coloredDot(50, 100);

        assertEquals(127, result.getRed());
        assertEquals(127, result.getGreen());
        assertEquals(127, result.getBlue());
    }
}
