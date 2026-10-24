package fr.univartois.butinfo.fractalens.complex.img.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fr.univartois.butinfo.fractalens.image.color.ColoredFixe;
import fr.univartois.butinfo.fractalens.image.color.ColoredRVB;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;
import org.junit.jupiter.api.Test;

/**
 * The EnumPaletteTest tests the {@link EnumPalette} enumeration.
 */
class EnumPaletteTest {

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * with a fixed palette.
     */
    @Test
    void testCreateFire() {
        IColor fire = EnumPalette.FIRE.create(100);
        assertNotNull(fire);
        assertInstanceOf(ColoredFixe.class, fire);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * with other fixed palettes.
     */
    @Test
    void testCreateOtherFixedPalettes() {
        assertInstanceOf(ColoredFixe.class, EnumPalette.OCEAN.create(100));
        assertInstanceOf(ColoredFixe.class, EnumPalette.NEON.create(100));
        assertInstanceOf(ColoredFixe.class, EnumPalette.RAINBOW.create(100));
        assertInstanceOf(ColoredFixe.class, EnumPalette.MINT_CHOCOLATE.create(100));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * with the custom RVB palette.
     */
    @Test
    void testCreateRvbCustom() {
        IColor rvb = EnumPalette.RVB_CUSTOM.create(100);
        assertNotNull(rvb);
        assertInstanceOf(ColoredRVB.class, rvb);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * with different sizes.
     */
    @Test
    void testCreateWithDifferentSizes() {
        assertNotNull(EnumPalette.FIRE.create(0));
        assertNotNull(EnumPalette.FIRE.create(1));
        assertNotNull(EnumPalette.FIRE.create(1000));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * called twice.
     */
    @Test
    void testCreateReturnsNewInstance() {
        assertNotSame(EnumPalette.FIRE.create(100), EnumPalette.FIRE.create(100));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#create(int)}
     * with every palette.
     */
    @Test
    void testCreateAllPalettes() {
        for (EnumPalette palette : EnumPalette.values()) {
            assertNotNull(palette.create(100));
        }
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#valueOf(java.lang.String)}.
     */
    @Test
    void testValueOf() {
        assertEquals(EnumPalette.FIRE, EnumPalette.valueOf("FIRE"));
        assertEquals(EnumPalette.OCEAN, EnumPalette.valueOf("OCEAN"));
        assertEquals(EnumPalette.RVB_CUSTOM, EnumPalette.valueOf("RVB_CUSTOM"));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.image.color.EnumPalette#valueOf(java.lang.String)}
     * with an unknown name.
     */
    @Test
    void testValueOfUnknown() {
        assertThrows(IllegalArgumentException.class, () -> EnumPalette.valueOf("UNKNOWN"));
    }

}
