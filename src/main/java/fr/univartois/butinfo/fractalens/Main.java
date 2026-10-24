package fr.univartois.butinfo.fractalens;

import java.util.concurrent.Callable;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;
import picocli.CommandLine;

/**
 * The Main class is the command-line entry point of FractaLens.
 * It reads the options given by the user and configures a
 * {@link FractalGeneratorBuilder} accordingly.
 */
@CommandLine.Command(
        name = "fractale",
        description = "Generate a fractal",
        version = "1.0.0"
)
public class Main implements Callable<Integer> {

    /**
     * The kinds of image that can be generated.
     */
    public enum ImageType {

        /** A single static image. */
        SINGLE,

        /** A progressive zoom on the center of the fractal. */
        ZOOM,

        /** A rotation of the constant of a Julia sequence. */
        ROTATION
    }

    @CommandLine.Option(
            names = {"--help"},
            usageHelp = true,
            description = "display this help message"
    )
    private boolean helpRequested;

    @CommandLine.Option(
            names = {"-V", "--version"},
            versionHelp = true,
            description = "display the version"
    )
    private boolean versionRequested;

    @CommandLine.Option(
            names = {"-f", "--fractal-name"},
            description = "name of the fractal (default = ${DEFAULT-VALUE}, "
                          + "values = ${COMPLETION-CANDIDATES}); ignored for the rotation type"
    )
    private EnumSequence sequence = EnumSequence.MANDELBROT;

    @CommandLine.Option(
            names = {"-h", "--height"},
            description = "height of the image in pixels (default = ${DEFAULT-VALUE})"
    )
    private int height = 400;

    @CommandLine.Option(
            names = {"-w", "--width"},
            description = "width of the image in pixels (default = ${DEFAULT-VALUE})"
    )
    private int width = 400;

    @CommandLine.Option(
            names = {"-s", "--scale"},
            description = "scale of the image: size of one pixel in the complex plane "
                          + "(default = ${DEFAULT-VALUE})"
    )
    private double scale = 0.005;

    @CommandLine.Option(
            names = {"-x", "--focus-x"},
            description = "real part of the center of the image (default = ${DEFAULT-VALUE})"
    )
    private double focusX = 0.0;

    @CommandLine.Option(
            names = {"-y", "--focus-y"},
            description = "imaginary part of the center of the image (default = ${DEFAULT-VALUE})"
    )
    private double focusY = 0.0;

    @CommandLine.Option(
            names = {"-n", "--nb-iterations"},
            description = "maximum number of iterations (default = ${DEFAULT-VALUE})"
    )
    private int maxIterations = 100;

    @CommandLine.Option(
            names = {"-p", "--palette-name"},
            description = "name of the colour palette (default = ${DEFAULT-VALUE}, "
                          + "values = ${COMPLETION-CANDIDATES})"
    )
    private EnumPalette palette = EnumPalette.GRAYSCALE;

    @CommandLine.Option(
            names = {"-t", "--type"},
            description = "type of image to generate (default = ${DEFAULT-VALUE}, "
                          + "values = ${COMPLETION-CANDIDATES})"
    )
    private ImageType type = ImageType.SINGLE;

    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "name of the output file (default = ${DEFAULT-VALUE}); "
                          + "use a .gif extension for zoom and rotation"
    )
    private String outputPath = "fractal.png";

    @CommandLine.Option(
            names = {"--frames"},
            description = "number of frames of the animation (default = ${DEFAULT-VALUE})"
    )
    private int frames = 40;

    @CommandLine.Option(
            names = {"--zoom-step"},
            description = "factor applied to the scale between two frames "
                          + "of a zoom (default = ${DEFAULT-VALUE})"
    )
    private double zoomStep = 0.80;

    /**
     * Launches the command-line interface.
     *
     * @param args The arguments given on the command line.
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main())
                .setCaseInsensitiveEnumValuesAllowed(true)
                .execute(args);
        System.exit(exitCode);
    }

    /**
     * Executes the command based on the provided configuration options.
     *
     * @return An integer exit code (0 for success, non-zero for failure).
     */
    @Override
    public Integer call() {
        if (!areOptionsValid()) {
            return 2;
        }

        System.out.println("Generating the fractal...");
        System.out.println(" -- fractal : " + sequence);
        System.out.println(" -- width : " + width);
        System.out.println(" -- height : " + height);
        System.out.println(" -- scale : " + scale);
        System.out.println(" -- focus : " + focusX + " + " + focusY + "i");
        System.out.println(" -- palette : " + palette);
        System.out.println(" -- nbIterations : " + maxIterations);
        System.out.println(" -- type : " + type);

        IColor colors = palette.create(maxIterations);
        IComplex center = new Complex(focusX, focusY);

        FractalGeneratorBuilder builder = new FractalGeneratorBuilder()
                .withSize(width, height)
                .withZoom(scale)
                .centeredAt(center)
                .withMaxIterations(maxIterations)
                .usingSequence(sequence)
                .usingPalette(colors)
                .outputToFile(outputPath);

        switch (type) {
            case ZOOM -> builder.buildZoomAnimation(frames, zoomStep).generateImage();

            case ROTATION -> {
                IComplex initialC = new Complex(-0.8, 0.156);
                builder.buildJuliaRotationAnimation(initialC, frames).generateImage();
            }
            case SINGLE -> {
                IFractalGenerator generator = builder.build();
                generator.generateImage();
                generator.saveImage();
            }
        }

        System.out.println("fractal successfully generated in " + outputPath);
        return 0;
    }

    /**
     * Checks that the values given by the user can be used to generate a fractal.
     *
     * @return Whether all the options are valid.
     */
    private boolean areOptionsValid() {
        if (width <= 0 || height <= 0) {
            System.err.println("The width and the height must be strictly positive.");
            return false;
        }
        if (maxIterations <= 0) {
            System.err.println("The maximum number of iterations must be strictly positive.");
            return false;
        }
        if (scale <= 0) {
            System.err.println("The scale must be strictly positive.");
            return false;
        }
        if (type != ImageType.SINGLE) {
            if (frames <= 0) {
                System.err.println("The number of frames must be strictly positive.");
                return false;
            }
            if (!outputPath.toLowerCase().endsWith(".gif")) {
                System.err.println("A zoom or a rotation must be saved in a .gif file.");
                return false;
            }
        }
        return true;
    }
}
