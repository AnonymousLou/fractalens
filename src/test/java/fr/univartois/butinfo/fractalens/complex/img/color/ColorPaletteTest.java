package fr.univartois.butinfo.fractalens.complex.img.color;

import fr.univartois.butinfo.fractalens.image.color.ColorPalette;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for {@link ColorPalette}.
 */
 class ColorPaletteTest {

    /**
     * Tests that all predefined palettes contain a non-null and non-empty list of colors.
     */
    @Test
    void testPalettesAreNotEmpty() {
        for (ColorPalette palette : ColorPalette.values()) {
            List<Color> colors = palette.getColors();
            assertNotNull(colors);
            assertFalse(colors.isEmpty());
        }
    }

    /**
     * Tests the {@link ColorPalette#size()} method for a specific palette.
     */
    @Test
    void testSize() {
        ColorPalette palette = ColorPalette.FIRE;
        assertEquals(palette.getColors().size(), palette.size());
    }

    /**
     * Tests retrieval of a color with a valid index.
     */
    @Test
    void testGetColorFirstIndex() {
        ColorPalette palette = ColorPalette.FIRE;
        Color expectedFirstColor = new Color(0, 0, 0);

        Color actualColor = palette.getColor(0);

        assertEquals(expectedFirstColor, actualColor);
    }

    /**
     * Tests that {@link ColorPalette#getColor(int)} correctly wraps around using modulo when index exceeds palette size.
     */
    @Test
    void testGetColorWithModulo() {
        ColorPalette palette = ColorPalette.OCEAN;
        int size = palette.size();

        // Index equal to size should wrap around to index 0
        Color colorAtZero = palette.getColor(0);
        Color colorWrapped = palette.getColor(size);

        assertEquals(colorAtZero, colorWrapped);
    }
}
