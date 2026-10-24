package fr.univartois.butinfo.fractalens.image;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The {@code FractalImage} class acts as an adapter.
 * It allows manipulating a {@link BufferedImage} using the {@link IFractalImage} interface methods.
 * @author Tom Deleau
 */
public class FractalImage implements IFractalImage {

    /**
     * The underlying image being adapted.
     */
    private BufferedImage img;

    /**
     * Constructs a new {@code FractalImage} adapter for the given {@code BufferedImage}.
     *
     * @param img the {@code BufferedImage} to be adapted and manipulated
     */
    public FractalImage(BufferedImage img) {
        this.img = img;
    }

    /**
     * Gets the height of the image.
     *
     * @return the height of the image in pixels
     */
    @Override
    public int getHeight() {
        return img.getHeight();
    }

    /**
     * Gets the width of the image.
     *
     * @return the width of the image in pixels
     */
    @Override
    public int getWidth() {
        return img.getWidth();
    }

    /**
     * Sets the color of a specific pixel in the image.
     *
     * @param row   the row of the pixel (y-coordinate)
     * @param column the column of the pixel (x-coordinate)
     * @param color  the {@link Color} to apply to the pixel
     */
    @Override
    public void setColor(int row, int column, Color color) {
        int rgb = color.getRGB();
        // The BufferedImage uses (x, y) coordinates, which corresponds to (column, row)
        img.setRGB(column, row, rgb);
    }

    /**
     * Saves the underlying image to the specified file path.
     * The image is saved in PNG format by default.
     *
     * @param path the destination path where the image will be saved
     * @throws IOException if an error occurs during writing
     */
    @Override
    public void saveAs(String path) throws IOException {
        File destinationFile = new File(path);
        ImageIO.write(img, "png", destinationFile);
    }

    /**
     * Returns the underlying {@link BufferedImage} of this fractal image.
     *
     * @return The underlying {@link BufferedImage} instance.
     */
    @Override
    public BufferedImage asBufferedImage() {
        return this.img;
    }
}
