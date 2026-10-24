package fr.univartois.butinfo.fractalens.complex.plane;

import fr.univartois.butinfo.fractalens.complex.IComplex;

/**
 * The {@code ZoomComplexPlane} class allows you to zoom a image
 *
 * @author Louis Dunocq
 *
 * @version 0.1.0
 */
public class ZoomComplexPlane implements IComplexPlane{

    /**
     *The complex plan that is decorated.
     */
    private IComplexPlane decorated;

    /**
     *The zoom power between 0 and 1.
     */
    private double zoom;

    /**
     *Construct a new instance of {@code ZoomComplexPlane} with the specified dimensions.
     *
     * @param decorator The complex plan that is decorated.
     * @param zoom The zoom power between 0 and 1.
     */
    public ZoomComplexPlane(IComplexPlane decorator, double zoom) {
        this.decorated = decorator;
        this.zoom = zoom;
    }

    /**
     *applies the zoom factor to the coordinates provided as a parameter
     *
     * @param row The row of the pixel in the image.
     * @param column The column of the pixel in the image.
     *
     * @return The complex number after applying the zoom.
     */
    @Override
    public IComplex asComplex(int row, int column) {
        IComplex beforeZoom = decorated.asComplex(row, column);
        return beforeZoom.multiply(zoom);
    }



}
