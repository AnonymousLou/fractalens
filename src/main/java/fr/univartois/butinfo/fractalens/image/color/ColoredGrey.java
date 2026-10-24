package fr.univartois.butinfo.fractalens.image.color;

import  java.awt.Color;

/**
 * The {@code ColoredGrey} class represents a grayscale color strategy
 * that maps the iteration count of a pixel to a shade of grey.
 *
 * @author Eva Nys
 *
 * @version 0.1.0
 */
public class ColoredGrey implements IColor {


    /**
     * Determines the grey color of a pixel based on the ratio of the current
     * iteration to the maximum number of iterations.
     *
     * @param iteration The iteration count for the pixel.
     * @param max       The maximum number of iterations.
     * @return The corresponding grayscale {@link Color} for the pixel.
     */
    @Override
    public Color coloredDot(int iteration, int max){
        float r = iteration / (float)max;
        float rgb = 1 - r;
        return new Color(rgb, rgb, rgb);
    }




}
