package fr.univartois.butinfo.fractalens.image.color;

import java.awt.*;

/**
 * The {@code ColoredGradient} class represents a gradient color strategy
 * that computes a smooth transition between two colors based on the iteration count.
 *
 * @author Louis Dunocq
 *
 * @version 0.1.0
 */
public class ColoredGradient implements IColor {

    // first color of gradiant
    private final Color firstColor;

    // second color of gradiant
    private final Color secondColor;

    /**
     * builder of the Gradient class
     * @param firstColor initialization of the first color
     * @param secondColor initialization of the second color
     */
    public ColoredGradient(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }

    /**
     * Determines the color of a pixel by interpolating between the first and second colors
     * based on the ratio of the current iteration to the maximum number of iterations.
     *
     * @param iteration The iteration count for the pixel.
     * @param max       The maximum number of iterations.
     * @return The interpolated {@link Color} for the pixel.
     */
    @Override
    public Color coloredDot(int iteration, int max) {

        float ratio = iteration / (float)max;
        float red = firstColor.getRed() + ratio * (secondColor.getRed() - firstColor.getRed());
        float green = firstColor.getGreen() + ratio * (secondColor.getGreen() - firstColor.getGreen());
        float blue = firstColor.getBlue() + ratio * (secondColor.getBlue() - firstColor.getBlue());
        return new Color((int) red, (int) green, (int) blue);
    }

}
