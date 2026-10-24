package fr.univartois.butinfo.fractalens.image.color;
import  java.awt.Color;

/**
 * The {@code IColor} interface defines a strategy for coloring pixels
 * based on their iteration count and the maximum number of iterations during fractal generation.
 *
 * @author Eva Nys
 *
 * @version 0.1.0
 */
public interface IColor {

    /**
     * Determines the color of a pixel based on its iteration count and the maximum number of iterations.
     *
     * @param iteration The iteration count for the pixel.
     * @param max       The maximum number of iterations.
     * @return The corresponding {@link Color} for the pixel.
     */
    Color coloredDot(int iteration, int max);

}
