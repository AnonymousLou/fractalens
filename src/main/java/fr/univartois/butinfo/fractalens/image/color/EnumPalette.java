package fr.univartois.butinfo.fractalens.image.color;

import java.util.function.Function;

/**
 * Énumération des stratégies de palettes de couleurs disponibles.
 *
 * @author  Louis Dunocq
 */
public enum EnumPalette {

    /**
     * Palette fixe basée sur les couleurs de feu.
     */
    FIRE(size -> new ColoredFixe(ColorPalette.FIRE)),

    /**
     * Palette fixe basée sur le thème de l'océan / la mer
     */
    OCEAN(size -> new ColoredFixe(ColorPalette.OCEAN)),

    /**
     * Palette fixe basée sur le thème des couleurs claires
     */
    CYAN(size -> new ColoredFixe(ColorPalette.CYAN)),

    /**
     * Palette fixe basée sur le thème néon
     */
    NEON(size -> new ColoredFixe(ColorPalette.NEON)),

    /**
     * Palette fixe basée sur le thème arc en ciel
     */
    RAINBOW(size -> new ColoredFixe(ColorPalette.RAINBOW)),

    /**
     * Palette fixe basée sur le thème pastel
     */
    PASTEL(size -> new ColoredFixe(ColorPalette.PASTEL)),

    /**
     * Palette fixe basée sur le thème julia sprint3
     */
    JULIA_SPRINT3(size -> new ColoredFixe(ColorPalette.JULIA_SPRINT3)),

    /**
     * Palette fixe basée sur le thème abyss
     */
    ABYSS(size -> new ColoredFixe(ColorPalette.ABYSS)),

    /**
     * Palette fixe basée sur le thème AURORA
     */
    AURORA(size -> new ColoredFixe(ColorPalette.AURORA)),

    /**
     * Palette fixe basée sur le thème EMERALD
     */
    EMERALD(size -> new ColoredFixe(ColorPalette.EMERALD)),

    /**
     * Palette fixe basée sur le thème BIOLUMINESCENCE
     */
    BIOLUMINESCENCE(size -> new ColoredFixe(ColorPalette.BIOLUMINESCENCE)),

    /**
     * Palette fixe basée sur le thème GLACIER
     */
    GLACIER(size -> new ColoredFixe(ColorPalette.GLACIER)),

    /**
     * Palette fixe basée sur le thème LAVA
     */
    LAVA(size -> new ColoredFixe(ColorPalette.LAVA)),

    /**
     * Palette fixe basée sur le thème SUNSET
     */
    SUNSET(size -> new ColoredFixe(ColorPalette.SUNSET)),

    /**
     * Palette fixe basée sur le thème SUNRISE
     */
    SUNRISE(size -> new ColoredFixe(ColorPalette.SUNRISE)),

    /**
     * Palette fixe basée sur le thème EMBER
     */
    EMBER(size -> new ColoredFixe(ColorPalette.EMBER)),

    /**
     * Palette fixe basée sur le thème VOLCANO
     */
    VOLCANO(size -> new ColoredFixe(ColorPalette.VOLCANO)),

    /**
     * Palette fixe basée sur le thème DESERT
     */
    DESERT(size -> new ColoredFixe(ColorPalette.DESERT)),

    /**
     * Palette fixe basée sur le thème AUTUMN
     */
    AUTUMN(size -> new ColoredFixe(ColorPalette.AUTUMN)),

    /**
     * Palette fixe basée sur le thème GOLD
     */
    GOLD(size -> new ColoredFixe(ColorPalette.GOLD)),

    /**
     * Palette fixe basée sur le thème COPPER
     */
    COPPER(size -> new ColoredFixe(ColorPalette.COPPER)),

    /**
     * Palette fixe basée sur le thème ICE
     */
    ICE(size -> new ColoredFixe(ColorPalette.ICE)),

    /**
     * Palette fixe basée sur le thème MIDNIGHT
     */
    MIDNIGHT(size -> new ColoredFixe(ColorPalette.MIDNIGHT)),

    /**
     * Palette fixe basée sur le thème DEEP_SPACE
     */
    DEEP_SPACE(size -> new ColoredFixe(ColorPalette.DEEP_SPACE)),

    /**
     * Palette fixe basée sur le thème GALAXY
     */
    GALAXY(size -> new ColoredFixe(ColorPalette.GALAXY)),

    /**
     * Palette fixe basée sur le thème NEBULA
     */
    NEBULA(size -> new ColoredFixe(ColorPalette.NEBULA)),

    /**
     * Palette fixe basée sur le thème ARCTIC
     */
    ARCTIC(size -> new ColoredFixe(ColorPalette.ARCTIC)),

    /**
     * Palette fixe basée sur le thème LAGOON
     */
    LAGOON(size -> new ColoredFixe(ColorPalette.LAGOON)),

    /**
     * Palette fixe basée sur le thème FOREST
     */
    FOREST(size -> new ColoredFixe(ColorPalette.FOREST)),

    /**
     * Palette fixe basée sur le thème JUNGLE
     */
    JUNGLE(size -> new ColoredFixe(ColorPalette.JUNGLE)),

    /**
     * Palette fixe basée sur le thème SPRING
     */
    SPRING(size -> new ColoredFixe(ColorPalette.SPRING)),

    /**
     * Palette fixe basée sur le thème TROPICAL
     */
    TROPICAL(size -> new ColoredFixe(ColorPalette.TROPICAL)),

    /**
     * Palette fixe basée sur le thème MOSS
     */
    MOSS(size -> new ColoredFixe(ColorPalette.MOSS)),

    /**
     * Palette fixe basée sur le thème SAKURA
     */
    SAKURA(size -> new ColoredFixe(ColorPalette.SAKURA)),

    /**
     * Palette fixe basée sur le thème CANDY
     */
    CANDY(size -> new ColoredFixe(ColorPalette.CANDY)),

    /**
     * Palette fixe basée sur le thème CYBERPUNK
     */
    CYBERPUNK(size -> new ColoredFixe(ColorPalette.CYBERPUNK)),

    /**
     * Palette fixe basée sur le thème SYNTHWAVE
     */
    SYNTHWAVE(size -> new ColoredFixe(ColorPalette.SYNTHWAVE)),

    /**
     * Palette fixe basée sur le thème VAPORWAVE
     */
    VAPORWAVE(size -> new ColoredFixe(ColorPalette.VAPORWAVE)),

    /**
     * Palette fixe basée sur le thème TOXIC
     */
    TOXIC(size -> new ColoredFixe(ColorPalette.TOXIC)),

    /**
     * Palette fixe basée sur le thème ELECTRIC
     */
    ELECTRIC(size -> new ColoredFixe(ColorPalette.ELECTRIC)),

    /**
     * Palette fixe basée sur le thème PSYCHEDELIC
     */
    PSYCHEDELIC(size -> new ColoredFixe(ColorPalette.PSYCHEDELIC)),

    /**
     * Palette fixe basée sur le thème GRAYSCALE
     */
    GRAYSCALE(size -> new ColoredFixe(ColorPalette.GRAYSCALE)),

    /**
     * Palette fixe basée sur le thème INVERTED_GRAY
     */
    INVERTED_GRAY(size -> new ColoredFixe(ColorPalette.INVERTED_GRAY)),

    /**
     * Palette fixe basée sur le thème SEPIA
     */
    SEPIA(size -> new ColoredFixe(ColorPalette.SEPIA)),

    /**
     * Palette fixe basée sur le thème BLUEPRINT
     */
    BLUEPRINT(size -> new ColoredFixe(ColorPalette.BLUEPRINT)),

    /**
     * Palette fixe basée sur le thème NEWSPAPER
     */
    NEWSPAPER(size -> new ColoredFixe(ColorPalette.NEWSPAPER)),

    /**
     * Palette fixe basée sur le thème THERMAL
     */
    THERMAL(size -> new ColoredFixe(ColorPalette.THERMAL)),

    /**
     * Palette fixe basée sur le thème VIRIDIS
     */
    VIRIDIS(size -> new ColoredFixe(ColorPalette.VIRIDIS)),

    /**
     * Palette fixe basée sur le thème MAGMA
     */
    MAGMA(size -> new ColoredFixe(ColorPalette.MAGMA)),

    /**
     * Palette fixe basée sur le thème PLASMA
     */
    PLASMA(size -> new ColoredFixe(ColorPalette.PLASMA)),

    /**
     * Palette fixe basée sur le thème INFERNO
     */
    INFERNO(size -> new ColoredFixe(ColorPalette.INFERNO)),

    /**
     * Palette fixe basée sur le thème TWILIGHT
     */
    TWILIGHT(size -> new ColoredFixe(ColorPalette.TWILIGHT)),

    /**
     * Palette fixe basée sur le thème MINT_CHOCOLATE
     */
    MINT_CHOCOLATE(size -> new ColoredFixe(ColorPalette.MINT_CHOCOLATE)),

    /**
     * Palette personnalisée avec une stratégie RVB (Sprint 3).
     */
    RVB_CUSTOM(size -> new ColoredRVB(new ColoredFixe(ColorPalette.JULIA_SPRINT3), 0.0, 1.0, 1.0));

    // Ajoute d'autres palettes ici selon ce que tu as dans ColorPalette...

    /**
     * La fonction permettant de créer l'instance de la stratégie de couleur.
     * Paramétrée par 'size' (le nombre max d'itérations ou la taille de la palette).
     */
    private final Function<Integer, IColor> factory;

    /**
     * Constructeur de l'énumération.
     *
     * @param factory La fonction de création de la palette
     */
    EnumPalette(Function<Integer, IColor> factory) {
        this.factory = factory;
    }

    /**
     * Crée et retourne la stratégie de couleur configurée.
     *
     * @param paletteSize La taille de la palette (généralement maxIterations)
     * @return L'instance de IColor
     */
    public IColor create(int paletteSize) {
        return factory.apply(paletteSize);
    }
}
