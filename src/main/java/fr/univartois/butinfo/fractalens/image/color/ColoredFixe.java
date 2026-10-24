package fr.univartois.butinfo.fractalens.image.color;

import java.awt.Color;
import java.util.List;

/**
 * The {@code ColoredFixe} class represents a fixed color mapping strategy
 * that maps fractal iteration counts to a predefined list of colors.
 *
 * @author  Tom Deleau
 *
 * @version 0.1.0
 */
public class ColoredFixe implements IColor {

    /**
     * The list of colors used for the color mapping.
     */
    private final List<Color> colors;
    /**
     * Constructs a new {@code ColoredFixe} using a color palette.
     *
     * @param palette The color palette containing the list of colors.
     */
    public ColoredFixe(ColorPalette palette) {
        this.colors = palette.getColors();
    }
    /**
     * Constructs a new {@code ColoredFixe} using a direct list of colors.
     *
     * @param colors The list of colors.
     */
    public ColoredFixe(List<Color> colors) {
        this.colors = colors;
    }
    /**
     * Determines the color of a pixel based on its iteration count and the maximum number of iterations.
     *
     * @param iteration The iteration count for the pixel.
     * @param max       The maximum number of iterations.
     * @return The corresponding {@link Color} from the list.
     */
    @Override
    public Color coloredDot(int iteration, int max) {
        int index = (int) ((double) iteration / max * colors.size());// Conversion en double pour éviter la division entière
        index = Math.min(index, colors.size() - 1);
        return colors.get(index);
    }
}
