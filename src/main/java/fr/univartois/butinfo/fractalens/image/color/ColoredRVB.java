package fr.univartois.butinfo.fractalens.image.color;

import java.awt.*;

/**
 * The {@code ColoredRVB} class represents a color decorator strategy
 * that modifies the red, green, and blue color channels of an underlying color strategy
 * by applying specific multiplicative factors.
 *
 * @author Tom Deleau
 *
 * @version 0.1.0
 */
public class ColoredRVB implements IColor {
    /**
     * The underlying color strategy being decorated.
     */
    private final IColor decor;
    /**
     * The multiplication factor applied to the red channel.
     */
    private final double redFactor;
    /**
     * The multiplication factor applied to the green channel.
     */
    private final double greenFactor;
    /**
     * The multiplication factor applied to the blue channel.
     */
    private final double blueFactor;

    /**
     * Constructs a new {@code ColoredRVB} with the specified underlying color strategy
     * and channel factors.
     *
     * @param decor       The underlying color strategy to decorate.
     * @param redFactor   The factor to apply to the red channel.
     * @param greenFactor The factor to apply to the green channel.
     * @param blueFactor  The factor to apply to the blue channel.
     */
    public ColoredRVB(IColor decor, double redFactor, double greenFactor,double blueFactor) {
        this.decor = decor;
        this.redFactor = redFactor;
        this.greenFactor = greenFactor;
        this.blueFactor = blueFactor;
    }

    /**
     * Determines the color of a pixel by obtaining the color from the decorated strategy
     * and scaling each of its RGB components by the respective factors.
     *
     * @param iteration The iteration count for the pixel.
     * @param max       The maximum number of iterations.
     * @return The adjusted {@link Color} for the pixel.
     */
    @Override
    public Color coloredDot(int iteration, int max) {
        Color baseColor = decor.coloredDot(iteration, max);
        int r = (int) (baseColor.getRed() * redFactor);
        int v = (int) (baseColor.getGreen() * greenFactor);
        int b = (int) (baseColor.getBlue() * blueFactor);
        return new Color(r, v, b);
    }

}
