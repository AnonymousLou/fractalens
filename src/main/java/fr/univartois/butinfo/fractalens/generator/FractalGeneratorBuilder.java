package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.TranslateComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.ZoomComplexPlane;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
import fr.univartois.butinfo.fractalens.image.FractalImage;
import fr.univartois.butinfo.fractalens.image.FractalImageComposite;
import fr.univartois.butinfo.fractalens.image.IFractalImage;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 *
 * @author Hugo Halipré, Tom Deleau, Eva Nys
 */
public class FractalGeneratorBuilder {

    /** The width of the generated image in pixels (default: 800). */
    private int width = 800;

    /** The height of the generated image in pixels (default: 600). */
    private int height = 600;

    /** The zoom factor applied to the complex plane (default: 1.0). */
    private double zoomFactor = 1.0;

    /** The translation vector applied to the complex plane. */
    private IComplex translation;

    /** The center point of the complex plane. */
    private IComplex center;

    /** The maximum number of iterations for sequence calculations (default: 100). */
    private int maxIterations = 100;

    /** The output file name for the image or animation. */
    private String fileName;

    /** The function used to create the complex number sequence. */
    private BiFunction<IComplex, Integer, IComplexSequence> function;

    /** The selected color palette enumeration. */
    private EnumPalette paletteEnum;

    /** The color palette instance used. */
    private IColor palette;

    /**
     * Sets the size of the image to be generated.
     *
     * @param width  The width in pixels.
     * @param height The height in pixels.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder withSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * Sets the zoom factor.
     *
     * @param zoomFactor The zoom factor to apply.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder withZoom(double zoomFactor) {
        this.zoomFactor = zoomFactor;
        return this;
    }

    /**
     * Applies a translation to the complex plane.
     *
     * @param translationFactor The complex number representing the translation.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder withTranslation(IComplex translationFactor) {
        this.translation = translationFactor;
        return this;
    }

    /**
     * Centers the complex plane on a given point.
     *
     * @param center The complex number representing the center.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder centeredAt(IComplex center) {
        this.center = center;
        return this;
    }

    /**
     * Sets the maximum number of iterations.
     *
     * @param maxIterations The maximum number of iterations.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder withMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        return this;
    }

    /**
     * Uses a predefined sequence from an enumeration.
     *
     * @param sequence The sequence enumeration.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder usingSequence(EnumSequence sequence) {
        if (sequence != null) {
            this.function = sequence::create;
        }
        return this;
    }

    /**
     * Uses a custom function to generate the sequence.
     *
     * @param function The binary function for sequence creation.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder usingSequence(BiFunction<IComplex, Integer, IComplexSequence> function) {
        this.function = function;
        return this;
    }

    /**
     * Uses a predefined color palette.
     *
     * @param paletteEnum The palette enumeration.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder usingPalette(EnumPalette paletteEnum) {
        this.paletteEnum = paletteEnum;
        this.palette = null;
        return this;
    }

    /**
     * Uses a custom color palette instance.
     *
     * @param palette The color palette instance.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder usingPalette(IColor palette) {
        this.palette = palette;
        this.paletteEnum = null;
        return this;
    }

    /**
     * Specifies the output file for saving.
     *
     * @param fileName The output file name.
     * @return The configured builder instance.
     */
    public FractalGeneratorBuilder outputToFile(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Builds and returns a {@code FractalGenerator} instance with the current configuration.
     *
     * @return The configured fractal generator.
     * @throws IllegalStateException if no sequence has been defined.
     */
    public FractalGenerator build() {
        if (function == null) {
            throw new IllegalStateException("Une séquence doit être définie avant de construire le générateur");
        }
        if (palette == null && paletteEnum != null) {
            palette = paletteEnum.create(maxIterations);
        }
        return new FractalGenerator(this);
    }

    /**
     * Builds a sequential zoom animation as a composite image.
     *
     * @param nbFrames       The number of frames in the animation.
     * @param zoomFactorStep The zoom factor step evolution per frame.
    30* @return A composite image generator representing the animation.
     */
    public IFractalGenerator buildZoomAnimation(int nbFrames, double zoomFactorStep) {
        List<IFractalGenerator> generators = new ArrayList<>();
        double currentZoom = this.zoomFactor;

        for (int i = 0; i < nbFrames; i++) {
            IFractalGenerator generator = new FractalGeneratorBuilder()
                    .withSize(this.width, this.height)
                    .withZoom(currentZoom)
                    .centeredAt(this.center)
                    .withMaxIterations(this.maxIterations)
                    .usingSequence(this.function)
                    .usingPalette(this.palette)
                    .build();

            generators.add(generator);
            currentZoom *= zoomFactorStep;
        }

        return new FractalImageComposite(generators, this.fileName);
    }

    /**
     * Builds a Julia constant rotation animation.
     *
     * @param initialC  The initial complex value of constant {@code c}.
     * @param nbFrames  The number of frames in the animation.
     * @return A composite image generator representing the rotation animation.
     */
    public IFractalGenerator buildJuliaRotationAnimation(IComplex initialC, int nbFrames) {
        List<IFractalGenerator> generators = new ArrayList<>();
        double angleStep = (2.0 * Math.PI) / nbFrames;

        for (int i = 0; i < nbFrames; i++) {
            double theta = i * angleStep;
            IComplex rotation = new Complex(Math.cos(theta), Math.sin(theta));
            IComplex rotatedC = initialC.multiply(rotation);

            IFractalGenerator generator = new FractalGeneratorBuilder()
                    .withSize(this.width, this.height)
                    .withZoom(this.zoomFactor)
                    .centeredAt(this.center)
                    .withMaxIterations(this.maxIterations)
                    .usingSequence((z0, max) -> new JuliaSequence(rotatedC, z0, max))
                    .usingPalette(this.palette)
                    .build();

            generators.add(generator);
        }

        return new FractalImageComposite(generators, this.fileName);
    }

    /**
     * Creates and returns a new empty fractal image based on current dimensions.
     *
     * @return An instance of {@link IFractalImage}.
     */
    public IFractalImage getImage() {
        return new FractalImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
    }

    /**
     * Builds and returns the complex plane configured with the current zoom and translation/center.
     *
     * @return The corresponding {@link IComplexPlane} instance.
     */
    public IComplexPlane getPlane() {
        IComplexPlane plane = new ComplexPlane(width, height);
        if (zoomFactor != 0.0 && zoomFactor != 1.0) {
            plane = new ZoomComplexPlane(plane, zoomFactor);
        }
        if (translation != null) {
            plane = new TranslateComplexPlane(plane, translation);
        } else if (center != null) {
            plane = new TranslateComplexPlane(plane, center);
        }
        return plane;
    }

    /** @return The image width. */
    public int getWidth() { return width; }

    /** @return The image height. */
    public int getHeight() { return height; }

    /** @return The current zoom factor. */
    public double getZoomFactor() { return zoomFactor; }

    /** @return The current center point. */
    public IComplex getCenter() { return center; }

    /** @return The maximum number of iterations. */
    public int getMaxIterations() { return maxIterations; }

    /** @return The output file name. */
    public String getFileName() { return fileName; }

    /** @return The sequence creation function. */
    public BiFunction<IComplex, Integer, IComplexSequence> getFunction() { return function; }

    /** @return The active color palette. */
    public IColor getPalette() { return palette; }
}
