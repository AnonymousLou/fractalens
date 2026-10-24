package fr.univartois.butinfo.fractalens.complex.img.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;

import fr.univartois.butinfo.fractalens.image.color.IColor;
import fr.univartois.butinfo.fractalens.image.color.ColoredInverse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The {@code ColoredInverseTest} class tests the {@link ColoredInverse} class.
 *
 * @version 0.1.0
 */
class ColoredInverseTest {

    /** The inverted color palette being tested. */
    private IColor invertedPalette;

    /**
     * A mock color palette implementation used for testing purposes.
     */
    private static class MockPalette implements IColor {

        /** The fixed color to return. */
        private final Color colorToReturn;

        /**
         * Constructs a new {@code MockPalette} returning the specified color.
         *
         * @param colorToReturn The color to return.
         */
        public MockPalette(Color colorToReturn) {
            this.colorToReturn = colorToReturn;
        }

        /**
         * Returns the predefined color regardless of the iteration and maximum values.
         *
         * @param iteration The iteration count.
         * @param max       The maximum number of iterations.
         * @return The mock {@link Color}.
         */
        @Override
        public Color coloredDot(int iteration, int max) {
            return colorToReturn;
        }
    }

    /**
     * Initializes the test environment with a mock palette and its inversion before each test.
     */
    @BeforeEach
    void initPalette() {
        IColor mockPalette = new MockPalette(new Color(100, 150, 200));
        invertedPalette = new ColoredInverse(mockPalette);
    }

    /**
     * Test method for verifying standard color inversion (complementary colors).
     */
    @Test
    void testStandardInversion() {
        Color result = invertedPalette.coloredDot(10, 100);

        assertEquals(255 - 100, result.getRed());
        assertEquals(255 - 150, result.getGreen());
        assertEquals(255 - 200, result.getBlue());
        assertNotEquals(new Color(100, 150, 200), result);
    }

    /**
     * Test method for verifying that black correctly inverts to white.
     */
    @Test
    void testBlackInversionToWhite() {
        IColor blackPalette = new MockPalette(Color.BLACK);
        IColor invertedBlack = new ColoredInverse(blackPalette);

        Color result = invertedBlack.coloredDot(0, 100);

        assertEquals(255, result.getRed());
        assertEquals(255, result.getGreen());
        assertEquals(255, result.getBlue());
        assertNotEquals(Color.BLACK, result);
    }

    /**
     * Test method for verifying that white correctly inverts to black.
     */
    @Test
    void testWhiteInversionToBlack() {
        IColor whitePalette = new MockPalette(Color.WHITE);
        IColor invertedWhite = new ColoredInverse(whitePalette);

        Color result = invertedWhite.coloredDot(100, 100);

        assertEquals(0, result.getRed());
        assertEquals(0, result.getGreen());
        assertEquals(0, result.getBlue());
        assertNotEquals(Color.WHITE, result);
    }
}