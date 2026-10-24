package fr.univartois.butinfo.fractalens.complex.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.image.IFractalImage;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;

/**
 * The FractalGeneratorTest tests the {@link FractalGenerator} class.
 */
class FractalGeneratorTest {

    /**
     * Creates a generator for a small image.
     *
     * @param outputPath The path of the file in which the image is saved.
     *
     * @return The created generator.
     */
    private static FractalGenerator createGenerator(String outputPath) {
        return new FractalGeneratorBuilder()
                .withSize(10, 10)
                .withMaxIterations(50)
                .usingSequence(EnumSequence.values()[0])
                .usingPalette(EnumPalette.FIRE)
                .outputToFile(outputPath)
                .build();
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#computePixelColor(int, int)}.
     */
    @Test
    void testComputePixelColor(@TempDir Path directory) {
        FractalGenerator generator = createGenerator(directory.resolve("fractal.png").toString());

        assertNotNull(generator.computePixelColor(0, 0));
        assertNotNull(generator.computePixelColor(5, 5));
        assertNotNull(generator.computePixelColor(9, 9));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#computePixelColor(int, int)}
     * called twice on the same pixel.
     */
    @Test
    void testComputePixelColorIsDeterministic(@TempDir Path directory) {
        FractalGenerator generator = createGenerator(directory.resolve("fractal.png").toString());

        assertEquals(generator.computePixelColor(3, 7), generator.computePixelColor(3, 7));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#generateImage()}.
     */
    @Test
    void testGenerateImage(@TempDir Path directory) {
        FractalGenerator generator = createGenerator(directory.resolve("fractal.png").toString());

        IFractalImage image = generator.generateImage();

        assertNotNull(image);
        assertEquals(10, image.getWidth());
        assertEquals(10, image.getHeight());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#generateImage()}
     * checking that the file is created.
     */
    @Test
    void testGenerateImageCreatesFile(@TempDir Path directory) {
        Path file = directory.resolve("fractal.png");
        FractalGenerator generator = createGenerator(file.toString());

        generator.generateImage();
        generator.saveImage(); // <-- On sauvegarde manuellement maintenant !

        assertTrue(Files.exists(file));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#saveImage()}.
     */
    @Test
    void testSaveImage(@TempDir Path directory) {
        Path file = directory.resolve("fractal.png");
        FractalGenerator generator = createGenerator(file.toString());

        generator.saveImage();

        assertTrue(Files.exists(file));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGenerator#saveImage()}
     * with a path that cannot be written.
     */
    @Test
    void testSaveImageError(@TempDir Path directory) {
        Path file = directory.resolve("unknown-folder").resolve("fractal.png");
        FractalGenerator generator = createGenerator(file.toString());

        assertThrows(UncheckedIOException.class, generator::saveImage);
    }

}
