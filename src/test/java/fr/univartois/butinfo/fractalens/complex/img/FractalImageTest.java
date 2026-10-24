package fr.univartois.butinfo.fractalens.complex.img;

import fr.univartois.butinfo.fractalens.image.FractalImage;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the {@link FractalImage} adapter.
 * It ensures 100% coverage of the adapter's methods.
 */
 class FractalImageTest {

    /**
     * Helper method to create a FractalImage instance.
     *
     * @param img the BufferedImage to adapt
     * @return a new FractalImage adapter
     */
    private static FractalImage createImage(BufferedImage img) {
        return new FractalImage(img);
    }

    /**
     * Tests the {@link FractalImage#getHeight()} method.
     */
    @Test
    void testGetHeight() {
        BufferedImage img = new BufferedImage(300, 200,1);
        FractalImage imgTest = createImage(img);

        int height = imgTest.getHeight();

        assertEquals(200, height);
        assertNotEquals(300, height);
    }

    /**
     * Tests the {@link FractalImage#getWidth()} method.
     */
    @Test
    void testGetWidth() {
        // Create an image with width=280, height=300
        BufferedImage img = new BufferedImage(280, 300,1);
        FractalImage imgTest = createImage(img);

        int width = imgTest.getWidth();

        assertEquals(280, width);
        assertNotEquals(300, width);
    }

    /**
     * Tests the {@link FractalImage#setColor(int, int, Color)} method.
     * Verifies that the correct coordinates are updated in the underlying BufferedImage.
     */
    @Test
    void testSetColor() {
        BufferedImage img = new BufferedImage(10, 10, 1);
        FractalImage imgTest = createImage(img);

        Color targetColor = Color.RED;
        int row = 5;
        int column = 3;

        imgTest.setColor(row, column, targetColor);

        int actualRgb = img.getRGB(column, row);

        assertEquals(targetColor.getRGB(), actualRgb);
    }

    /**
     * Tests the {@link FractalImage#saveAs(String)} method.
     * Verifies that the file is successfully created on the disk.
     *
     * @throws IOException if temporary file creation fails
     */
    @Test
    void testSaveAs() throws IOException {
        BufferedImage img = new BufferedImage(10, 10, 1);
        FractalImage imgTest = createImage(img);

        File tmpFile = File.createTempFile("fractal_test_image", ".png");
        tmpFile.deleteOnExit();

        imgTest.saveAs(tmpFile.getAbsolutePath());

        assertTrue(tmpFile.exists());
        assertTrue(tmpFile.length() > 0);
    }
}
