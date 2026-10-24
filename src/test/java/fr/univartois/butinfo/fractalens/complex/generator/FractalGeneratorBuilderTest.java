package fr.univartois.butinfo.fractalens.complex.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;
import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.TranslateComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.ZoomComplexPlane;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;

/**
 * The FractalGeneratorBuilderTest tests the {@link FractalGeneratorBuilder} class.
 */
class FractalGeneratorBuilderTest {

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#withSize(int, int)}.
     */
    @Test
    void testWithSize() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().withSize(20, 10);

        assertEquals(20, builder.getWidth());
        assertEquals(10, builder.getHeight());
        assertEquals(20, builder.getImage().getWidth());
        assertEquals(10, builder.getImage().getHeight());
        assertInstanceOf(ComplexPlane.class, builder.getPlane());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#withZoom(double)}.
     */
    @Test
    void testWithZoom() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().withSize(20, 10).withZoom(2.5);

        assertEquals(2.5, builder.getZoomFactor(), 0.001);
        assertInstanceOf(ZoomComplexPlane.class, builder.getPlane());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#withTranslation(IComplex)}.
     */
    @Test
    void testWithTranslation() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().withSize(20, 10)
                .withTranslation(new Complex(1, 1));

        assertInstanceOf(TranslateComplexPlane.class, builder.getPlane());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#centeredAt(IComplex)}.
     */
    @Test
    void testCenteredAt() {
        IComplex center = new Complex(1, 2);
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().withSize(20, 10).centeredAt(center);

        assertSame(center, builder.getCenter());
        assertInstanceOf(TranslateComplexPlane.class, builder.getPlane());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#withMaxIterations(int)}.
     */
    @Test
    void testWithMaxIterations() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().withMaxIterations(150);

        assertEquals(150, builder.getMaxIterations());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#usingSequence(EnumSequence)}.
     */
    @Test
    void testUsingSequenceEnum() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().usingSequence(EnumSequence.values()[0]);

        assertNotNull(builder.getFunction());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#usingSequence(java.util.function.BiFunction)}.
     */
    @Test
    void testUsingSequenceFunction() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().usingSequence((z, max) -> null);

        assertNotNull(builder.getFunction());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#usingPalette(EnumPalette)}.
     */
    @Test
    void testUsingPaletteEnum() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder();
        builder.withMaxIterations(100);
        builder.usingSequence(EnumSequence.MANDELBROT); // Obligatoire pour pouvoir build()
        builder.usingPalette(EnumPalette.FIRE);

        builder.build(); // <-- On déclenche la construction réelle

        assertNotNull(builder.getPalette());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#usingPalette(IColor)}.
     */
    @Test
    void testUsingPaletteColor() {
        IColor palette = EnumPalette.OCEAN.create(100);
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().usingPalette(palette);

        assertSame(palette, builder.getPalette());
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#outputToFile(String)}.
     */
    @Test
    void testOutputToFile() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder().outputToFile("fractal.png");

        assertEquals("fractal.png", builder.getFileName());
    }

    /**
     * Test method for the fluent API of
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder}.
     */
    @Test
    void testMethodsReturnTheBuilder() {
        FractalGeneratorBuilder builder = new FractalGeneratorBuilder();

        assertSame(builder, builder.withSize(20, 10));
        assertSame(builder, builder.withZoom(2));
        assertSame(builder, builder.withMaxIterations(50));
        assertSame(builder, builder.usingPalette(EnumPalette.FIRE));
        assertSame(builder, builder.outputToFile("fractal.png"));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder#build()}.
     */
    @Test
    void testBuild() {
        FractalGenerator generator = new FractalGeneratorBuilder()
                .withSize(20, 10)
                .withMaxIterations(50)
                .usingSequence(EnumSequence.values()[0])
                .usingPalette(EnumPalette.FIRE)
                .outputToFile("fractal.png")
                .build();

        assertNotNull(generator);
    }

    /**
     * Test method for {@link FractalGeneratorBuilder#buildZoomAnimation(int, double)}.
     */
    @Test
    void testZoomAnimated() {
        int nbFrames = 5;
        double zoomStep = 1.5;

        IFractalGenerator animation = new FractalGeneratorBuilder()
                .withSize(20, 10)
                .withZoom(1.0)
                .centeredAt(new Complex(0, 0))
                .withMaxIterations(50)
                .usingSequence(EnumSequence.MANDELBROT)
                .usingPalette(EnumPalette.FIRE)
                .outputToFile("zoom_animation.gif")
                .buildZoomAnimation(nbFrames, zoomStep);

        assertNotNull(animation);
    }

    /**
     * Test method for {@link FractalGeneratorBuilder#buildJuliaRotationAnimation(IComplex, int)}.
     */
    @Test
    void testRotationAnimated() {
        IComplex initialC = new Complex(-0.4, 0.6);
        int nbFrames = 10;

        IFractalGenerator animation = new FractalGeneratorBuilder()
                .withSize(20, 10)
                .withZoom(1.0)
                .centeredAt(new Complex(0, 0))
                .withMaxIterations(50)
                .usingSequence(EnumSequence.GENERALIZED_JULIA)
                .usingPalette(EnumPalette.FIRE)
                .outputToFile("julia_rotation.gif")
                .buildJuliaRotationAnimation(initialC, nbFrames);

        assertNotNull(animation);
    }

}
