package fr.univartois.butinfo.fractalens.image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;

import java.awt.*;

/**
 * The {@code FractalImageComposite} class implements the Composite pattern for fractal generators.
 * It manages a sequence of generators to produce an animated GIF composed of multiple frames.
 *
 * @author Tom Deleau
 *
 * @version 0.1.0
 */
public class FractalImageComposite implements IFractalGenerator {
    /**
     * The list of individual fractal generators representing each frame of the animation.
     */
    private final List<IFractalGenerator> generators;
    /**
     * The file path where the generated animated GIF will be saved.
     */
    private final String outputPath;
    /**
     * The list of buffered images corresponding to each frame of the animation.
     */
    private final List<BufferedImage> frames;

    /**
     * Constructs a new {@code FractalImageComposite} with the specified generators and output path.
     *
     * @param generators The list of fractal generators for the animation frames.
     * @param outputPath The file path where the output GIF should be saved.
     */
    public FractalImageComposite(List<IFractalGenerator> generators,
            String outputPath) {

        this.generators = generators;
        this.outputPath = outputPath;
        this.frames = new ArrayList<>();
    }

    /**
     * Generates all individual frame images by executing each underlying generator,
     * collects them, saves the resulting animation to disk, and returns the final frame image.
     *
     * @return The final {@link IFractalImage} generated in the sequence.
     */
    @Override
    public IFractalImage generateImage() {
        IFractalImage image=null;
        for (IFractalGenerator generator : generators) {
            image = generator.generateImage();
            frames.add(image.asBufferedImage());
        }
        saveImage();
        return image;
    }

    /**
     * Computes the color for a specific pixel.
     * This operation is not supported for composite animation generators.
     *
     * @param row    The row index of the pixel.
     * @param column The column index of the pixel.
     * @return Nothing, as an exception is always thrown.
     * @throws UnsupportedOperationException always, because this is a composite animation generator.
     */
    @Override
    public Color computePixelColor(int row, int column) {
        throw  new UnsupportedOperationException();
    }

    /**
     * Encodes and saves the accumulated frames into an animated GIF file
     * at the specified output path using an {@link AnimatedGifEncoder}.
     */
    @Override
    public void saveImage() {
        AnimatedGifEncoder encoder= new AnimatedGifEncoder();
        encoder.start(outputPath);
        encoder.setDelay(100);
        encoder.setRepeat(0);
        for(BufferedImage frame : frames){
            encoder.addFrame(frame);
        }
        encoder.finish();
    }

}
