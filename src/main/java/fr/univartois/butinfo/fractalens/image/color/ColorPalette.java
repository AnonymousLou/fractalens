package fr.univartois.butinfo.fractalens.image.color;

import java.awt.Color;
import java.util.List;

/**
 * Ensemble de palettes de couleurs prédéfinies pour la palette fixe.
 * Chaque palette contient au moins 10 couleurs.
 *
 * @author Tom Deleau
 */
public enum ColorPalette {

    // ===================== PALETTES D'ORIGINE =====================

    FIRE(List.of(
            new Color(0, 0, 0),             // Noir (divergence rapide / fond)
            new Color(32, 0, 0),
            new Color(64, 0, 0),            // Rouge très sombre
            new Color(122, 10, 0),
            new Color(180, 20, 0),          // Rouge feu
            new Color(218, 60, 0),
            new Color(255, 100, 0),         // Orange intense
            new Color(255, 150, 0),
            new Color(255, 200, 0),         // Jaune éclatant
            new Color(255, 255, 200)        // Blanc chaud
    )),

    OCEAN(List.of(
            new Color(0, 5, 20),            // Bleu nuit très sombre
            new Color(0, 17, 45),
            new Color(0, 28, 70),
            new Color(0, 40, 95),           // Bleu marine
            new Color(0, 75, 132),
            new Color(0, 110, 170),         // Bleu océan
            new Color(0, 150, 190),
            new Color(0, 190, 210),         // Cyan / Turquoise
            new Color(90, 215, 232),
            new Color(180, 240, 255)        // Blanc écume
    )),

    CYAN(List.of(
            new Color(0, 15, 25),           // Bleu nuit profond (fond)
            new Color(0, 37, 57),
            new Color(0, 58, 88),
            new Color(0, 80, 120),          // Cyan sombre
            new Color(0, 130, 165),
            new Color(0, 180, 210),         // Cyan électrique
            new Color(40, 210, 225),
            new Color(80, 240, 240),        // Aquamarine clair
            new Color(150, 248, 248),
            new Color(220, 255, 255)        // Blanc glacé
    )),

    NEON(List.of(
            new Color(15, 0, 25),           // Violet sombre
            new Color(50, 0, 83),
            new Color(85, 0, 142),
            new Color(120, 0, 200),         // Violet néon
            new Color(188, 0, 165),
            new Color(255, 0, 130),         // Rose fuchsia
            new Color(128, 120, 175),
            new Color(0, 240, 220),         // Cyan fluo
            new Color(128, 248, 110),
            new Color(255, 255, 0)          // Jaune fluo
    )),

    RAINBOW(List.of(
            new Color(0, 0, 0),             // Noir
            new Color(38, 0, 65),
            new Color(75, 0, 130),          // Indigo
            new Color(38, 0, 192),
            new Color(0, 0, 255),           // Bleu
            new Color(0, 255, 0),           // Vert
            new Color(255, 255, 0),         // Jaune
            new Color(255, 200, 0),         // Orange
            new Color(255, 0, 0),           // Rouge
            new Color(255, 255, 255)        // Blanc
    )),

    PASTEL(List.of(
            new Color(40, 40, 60),          // Gris bleu sombre
            new Color(110, 100, 130),
            new Color(180, 160, 200),       // Lilas
            new Color(170, 180, 210),
            new Color(160, 200, 220),       // Bleu pastel
            new Color(170, 215, 210),
            new Color(180, 230, 200),       // Vert menthe
            new Color(215, 225, 190),
            new Color(250, 220, 180),       // Pêche
            new Color(255, 255, 255)        // Blanc
    )),

    // ===================== PALETTES SPÉCIALES (conçues pour ColoredRVB(0.0, 1.0, 1.0)) =====================

    JULIA_SPRINT3(List.of(
            new Color(0, 0, 10),            // Quasi noir bleuté (fond)
            new Color(0, 10, 40),
            new Color(0, 20, 70),           // Bleu nuit
            new Color(0, 60, 140),          // Bleu profond
            new Color(0, 110, 200),         // Bleu vif
            new Color(0, 170, 220),         // Bleu ciel
            new Color(0, 220, 200),         // Turquoise
            new Color(0, 255, 160),         // Vert menthe électrique
            new Color(0, 200, 120),         // Vert émeraude
            new Color(0, 255, 255)          // Cyan pur
    )),

    ABYSS(List.of(
            new Color(0, 0, 0),             // Noir abyssal
            new Color(0, 5, 20),
            new Color(0, 10, 40),           // Bleu encre
            new Color(0, 25, 65),
            new Color(0, 40, 90),           // Bleu des profondeurs
            new Color(0, 65, 110),
            new Color(0, 90, 130),          // Bleu-vert sombre
            new Color(0, 150, 150),         // Sarcelle
            new Color(0, 220, 180),         // Vert lagon
            new Color(0, 255, 230)          // Cyan lumineux
    )),

    AURORA(List.of(
            new Color(0, 5, 20),            // Ciel polaire
            new Color(0, 32, 50),
            new Color(0, 60, 80),           // Vert-bleu sombre
            new Color(0, 110, 95),
            new Color(0, 160, 110),         // Vert aurore
            new Color(0, 208, 125),
            new Color(0, 255, 140),         // Vert fluo
            new Color(0, 200, 255),         // Bleu glacier
            new Color(0, 80, 220),          // Bleu électrique
            new Color(0, 255, 200)          // Turquoise vif
    )),

    EMERALD(List.of(
            new Color(0, 10, 5),            // Vert presque noir
            new Color(0, 35, 18),
            new Color(0, 60, 30),           // Vert forêt
            new Color(0, 95, 50),
            new Color(0, 130, 70),          // Vert émeraude
            new Color(0, 165, 90),
            new Color(0, 200, 110),         // Vert jade
            new Color(0, 228, 135),
            new Color(0, 255, 160),         // Vert menthe
            new Color(0, 255, 230)          // Aqua
    )),

    BIOLUMINESCENCE(List.of(
            new Color(0, 0, 15),            // Noir bleuté
            new Color(0, 15, 68),
            new Color(0, 30, 120),          // Bleu profond
            new Color(0, 75, 188),
            new Color(0, 120, 255),         // Bleu néon
            new Color(0, 188, 238),
            new Color(0, 255, 220),         // Cyan fluo
            new Color(0, 255, 100),         // Vert fluo
            new Color(0, 90, 160),          // Bleu océan
            new Color(0, 255, 255)          // Cyan éclatant
    )),

    GLACIER(List.of(
            new Color(0, 15, 40),           // Bleu glace sombre
            new Color(0, 42, 80),
            new Color(0, 70, 120),          // Bleu glacier
            new Color(0, 105, 155),
            new Color(0, 140, 190),         // Bleu clair
            new Color(0, 170, 210),
            new Color(0, 200, 230),         // Bleu givré
            new Color(0, 222, 242),
            new Color(0, 245, 255),         // Cyan glacé
            new Color(0, 255, 255)          // Cyan lumineux
    )),

    // ===================== CHAUDES =====================

    LAVA(List.of(
            new Color(10, 0, 0),
            new Color(50, 0, 0),
            new Color(90, 0, 0),
            new Color(145, 15, 0),
            new Color(200, 30, 0),
            new Color(228, 60, 0),
            new Color(255, 90, 0),
            new Color(255, 130, 10),
            new Color(255, 170, 20),
            new Color(255, 240, 120)
    )),

    SUNSET(List.of(
            new Color(20, 0, 40),           // Violet nuit
            new Color(55, 0, 70),
            new Color(90, 0, 100),          // Pourpre
            new Color(145, 15, 95),
            new Color(200, 30, 90),         // Rose vif
            new Color(228, 65, 70),
            new Color(255, 100, 50),        // Orange corail
            new Color(255, 140, 45),
            new Color(255, 180, 40),        // Or
            new Color(255, 240, 180)        // Crème
    )),

    SUNRISE(List.of(
            new Color(25, 10, 60),
            new Color(68, 25, 95),
            new Color(110, 40, 130),
            new Color(170, 60, 120),
            new Color(230, 80, 110),
            new Color(242, 115, 95),
            new Color(255, 150, 80),
            new Color(255, 180, 95),
            new Color(255, 210, 110),
            new Color(255, 250, 220)
    )),

    EMBER(List.of(
            new Color(5, 0, 0),
            new Color(23, 3, 0),
            new Color(42, 7, 0),
            new Color(60, 10, 0),
            new Color(95, 20, 0),
            new Color(130, 30, 0),
            new Color(175, 50, 0),
            new Color(220, 70, 0),
            new Color(238, 105, 10),
            new Color(255, 140, 20)
    )),

    VOLCANO(List.of(
            new Color(0, 0, 0),
            new Color(25, 0, 0),
            new Color(50, 0, 0),
            new Color(100, 0, 0),
            new Color(150, 0, 0),
            new Color(202, 30, 0),
            new Color(255, 60, 0),
            new Color(255, 160, 0),
            new Color(255, 255, 80),
            new Color(255, 255, 255)
    )),

    DESERT(List.of(
            new Color(40, 20, 10),
            new Color(80, 40, 15),
            new Color(120, 60, 20),
            new Color(155, 90, 35),
            new Color(190, 120, 50),
            new Color(210, 150, 75),
            new Color(230, 180, 100),
            new Color(240, 200, 130),
            new Color(250, 220, 160),
            new Color(255, 245, 220)
    )),

    AUTUMN(List.of(
            new Color(30, 10, 0),
            new Color(70, 20, 0),
            new Color(110, 30, 0),
            new Color(150, 50, 5),
            new Color(190, 70, 10),
            new Color(210, 100, 15),
            new Color(230, 130, 20),
            new Color(220, 155, 30),
            new Color(210, 180, 40),
            new Color(120, 90, 20)
    )),

    GOLD(List.of(
            new Color(10, 5, 0),
            new Color(45, 28, 0),
            new Color(80, 50, 0),
            new Color(125, 85, 0),
            new Color(170, 120, 0),
            new Color(200, 150, 10),
            new Color(230, 180, 20),
            new Color(242, 198, 40),
            new Color(255, 215, 60),
            new Color(255, 250, 200)
    )),

    COPPER(List.of(
            new Color(15, 5, 0),
            new Color(48, 20, 8),
            new Color(80, 35, 15),
            new Color(115, 58, 28),
            new Color(150, 80, 40),
            new Color(175, 100, 55),
            new Color(200, 120, 70),
            new Color(218, 145, 95),
            new Color(235, 170, 120),
            new Color(255, 225, 190)
    )),

    // ===================== FROIDES =====================

    ICE(List.of(
            new Color(0, 10, 30),
            new Color(10, 33, 67),
            new Color(20, 57, 103),
            new Color(30, 80, 140),
            new Color(65, 120, 180),
            new Color(100, 160, 220),
            new Color(145, 192, 238),
            new Color(190, 225, 255),
            new Color(218, 238, 255),
            new Color(245, 252, 255)
    )),

    MIDNIGHT(List.of(
            new Color(0, 0, 10),
            new Color(3, 3, 23),
            new Color(7, 7, 37),
            new Color(10, 10, 50),
            new Color(18, 18, 80),
            new Color(25, 25, 110),
            new Color(42, 42, 140),
            new Color(60, 60, 170),
            new Color(95, 95, 195),
            new Color(130, 130, 220)
    )),

    DEEP_SPACE(List.of(
            new Color(0, 0, 0),
            new Color(8, 0, 20),
            new Color(15, 0, 40),
            new Color(28, 5, 70),
            new Color(40, 10, 100),
            new Color(65, 25, 135),
            new Color(90, 40, 170),
            new Color(125, 75, 200),
            new Color(160, 110, 230),
            new Color(230, 220, 255)
    )),

    GALAXY(List.of(
            new Color(0, 0, 15),
            new Color(20, 0, 52),
            new Color(40, 0, 90),
            new Color(75, 10, 125),
            new Color(110, 20, 160),
            new Color(155, 40, 170),
            new Color(200, 60, 180),
            new Color(130, 80, 200),
            new Color(60, 100, 220),
            new Color(200, 230, 255)
    )),

    NEBULA(List.of(
            new Color(5, 0, 20),
            new Color(38, 0, 65),
            new Color(70, 0, 110),
            new Color(115, 15, 125),
            new Color(160, 30, 140),
            new Color(195, 60, 145),
            new Color(230, 90, 150),
            new Color(145, 105, 175),
            new Color(60, 120, 200),
            new Color(160, 220, 255)
    )),

    ARCTIC(List.of(
            new Color(10, 25, 45),
            new Color(20, 47, 73),
            new Color(30, 68, 102),
            new Color(40, 90, 130),
            new Color(75, 130, 165),
            new Color(110, 170, 200),
            new Color(150, 198, 220),
            new Color(190, 225, 240),
            new Color(220, 240, 248),
            new Color(250, 255, 255)
    )),

    LAGOON(List.of(
            new Color(0, 25, 35),
            new Color(0, 47, 57),
            new Color(0, 68, 78),
            new Color(0, 90, 100),
            new Color(0, 125, 130),
            new Color(0, 160, 160),
            new Color(40, 188, 180),
            new Color(80, 215, 200),
            new Color(135, 232, 218),
            new Color(190, 250, 235)
    )),

    // ===================== NATURE =====================

    FOREST(List.of(
            new Color(0, 15, 5),
            new Color(5, 38, 12),
            new Color(10, 60, 20),
            new Color(20, 85, 30),
            new Color(30, 110, 40),
            new Color(60, 135, 50),
            new Color(90, 160, 60),
            new Color(130, 185, 80),
            new Color(170, 210, 100),
            new Color(230, 245, 180)
    )),

    JUNGLE(List.of(
            new Color(0, 10, 0),
            new Color(0, 40, 10),
            new Color(0, 70, 20),
            new Color(10, 105, 30),
            new Color(20, 140, 40),
            new Color(70, 170, 35),
            new Color(120, 200, 30),
            new Color(170, 215, 35),
            new Color(220, 230, 40),
            new Color(255, 120, 0)
    )),

    SPRING(List.of(
            new Color(30, 60, 30),
            new Color(53, 97, 47),
            new Color(77, 133, 63),
            new Color(100, 170, 80),
            new Color(140, 195, 95),
            new Color(180, 220, 110),
            new Color(215, 210, 165),
            new Color(250, 200, 220),
            new Color(252, 222, 235),
            new Color(255, 245, 250)
    )),

    TROPICAL(List.of(
            new Color(0, 40, 50),
            new Color(0, 77, 77),
            new Color(0, 113, 103),
            new Color(0, 150, 130),
            new Color(125, 185, 95),
            new Color(250, 220, 60),
            new Color(252, 170, 60),
            new Color(255, 120, 60),
            new Color(242, 80, 80),
            new Color(230, 40, 100)
    )),

    MOSS(List.of(
            new Color(15, 20, 5),
            new Color(27, 37, 10),
            new Color(38, 53, 15),
            new Color(50, 70, 20),
            new Color(75, 95, 30),
            new Color(100, 120, 40),
            new Color(125, 142, 60),
            new Color(150, 165, 80),
            new Color(178, 188, 115),
            new Color(205, 210, 150)
    )),

    SAKURA(List.of(
            new Color(50, 20, 40),
            new Color(87, 37, 63),
            new Color(123, 53, 87),
            new Color(160, 70, 110),
            new Color(200, 105, 140),
            new Color(240, 140, 170),
            new Color(248, 170, 192),
            new Color(255, 200, 215),
            new Color(255, 220, 230),
            new Color(255, 240, 245)
    )),

    // ===================== VIVES / ARTIFICIELLES =====================

    CANDY(List.of(
            new Color(60, 0, 80),
            new Color(158, 40, 130),
            new Color(255, 80, 180),
            new Color(255, 140, 130),
            new Color(255, 200, 80),
            new Color(178, 215, 150),
            new Color(100, 230, 220),
            new Color(145, 185, 238),
            new Color(190, 140, 255),
            new Color(255, 255, 255)
    )),

    CYBERPUNK(List.of(
            new Color(5, 0, 20),
            new Color(23, 0, 57),
            new Color(42, 0, 93),
            new Color(60, 0, 130),
            new Color(158, 0, 150),
            new Color(255, 0, 170),
            new Color(128, 115, 212),
            new Color(0, 230, 255),
            new Color(128, 235, 128),
            new Color(255, 240, 0)
    )),

    SYNTHWAVE(List.of(
            new Color(15, 0, 40),
            new Color(52, 0, 95),
            new Color(90, 0, 150),
            new Color(172, 20, 155),
            new Color(255, 40, 160),
            new Color(255, 90, 110),
            new Color(255, 140, 60),
            new Color(255, 185, 80),
            new Color(255, 230, 100),
            new Color(0, 220, 255)
    )),

    VAPORWAVE(List.of(
            new Color(30, 10, 70),
            new Color(63, 27, 113),
            new Color(97, 43, 157),
            new Color(130, 60, 200),
            new Color(192, 85, 200),
            new Color(255, 110, 200),
            new Color(182, 170, 215),
            new Color(110, 230, 230),
            new Color(182, 240, 200),
            new Color(255, 250, 170)
    )),

    TOXIC(List.of(
            new Color(5, 10, 0),
            new Color(17, 33, 0),
            new Color(28, 57, 0),
            new Color(40, 80, 0),
            new Color(80, 140, 0),
            new Color(120, 200, 0),
            new Color(160, 228, 0),
            new Color(200, 255, 0),
            new Color(160, 128, 80),
            new Color(120, 0, 160)
    )),

    ELECTRIC(List.of(
            new Color(0, 0, 20),
            new Color(0, 0, 67),
            new Color(0, 0, 113),
            new Color(0, 0, 160),
            new Color(0, 60, 208),
            new Color(0, 120, 255),
            new Color(90, 180, 255),
            new Color(180, 240, 255),
            new Color(218, 248, 255),
            new Color(255, 255, 255)
    )),

    PSYCHEDELIC(List.of(
            new Color(255, 0, 0),
            new Color(255, 80, 0),
            new Color(255, 160, 0),
            new Color(255, 208, 0),
            new Color(255, 255, 0),
            new Color(128, 255, 0),
            new Color(0, 255, 0),
            new Color(0, 160, 255),
            new Color(160, 0, 255),
            new Color(255, 0, 160)
    )),

    // ===================== SOBRES / TECHNIQUES =====================

    GRAYSCALE(List.of(
            new Color(0, 0, 0),
            new Color(20, 20, 20),
            new Color(40, 40, 40),
            new Color(60, 60, 60),
            new Color(90, 90, 90),
            new Color(120, 120, 120),
            new Color(155, 155, 155),
            new Color(190, 190, 190),
            new Color(222, 222, 222),
            new Color(255, 255, 255)
    )),

    INVERTED_GRAY(List.of(
            new Color(255, 255, 255),
            new Color(233, 233, 233),
            new Color(212, 212, 212),
            new Color(190, 190, 190),
            new Color(155, 155, 155),
            new Color(120, 120, 120),
            new Color(90, 90, 90),
            new Color(60, 60, 60),
            new Color(30, 30, 30),
            new Color(0, 0, 0)
    )),

    SEPIA(List.of(
            new Color(20, 10, 0),
            new Color(40, 23, 8),
            new Color(60, 37, 17),
            new Color(80, 50, 25),
            new Color(110, 75, 42),
            new Color(140, 100, 60),
            new Color(170, 130, 85),
            new Color(200, 160, 110),
            new Color(222, 192, 150),
            new Color(245, 225, 190)
    )),

    BLUEPRINT(List.of(
            new Color(0, 20, 60),
            new Color(3, 33, 83),
            new Color(7, 47, 107),
            new Color(10, 60, 130),
            new Color(25, 85, 160),
            new Color(40, 110, 190),
            new Color(85, 145, 210),
            new Color(130, 180, 230),
            new Color(182, 212, 242),
            new Color(235, 245, 255)
    )),

    NEWSPAPER(List.of(
            new Color(20, 20, 20),
            new Color(43, 43, 42),
            new Color(67, 67, 63),
            new Color(90, 90, 85),
            new Color(125, 124, 118),
            new Color(160, 158, 150),
            new Color(188, 185, 175),
            new Color(215, 212, 200),
            new Color(230, 227, 215),
            new Color(245, 242, 230)
    )),

    THERMAL(List.of(
            new Color(0, 0, 40),
            new Color(30, 0, 90),
            new Color(60, 0, 140),
            new Color(125, 0, 120),
            new Color(190, 0, 100),
            new Color(222, 50, 50),
            new Color(255, 100, 0),
            new Color(255, 160, 0),
            new Color(255, 220, 0),
            new Color(255, 255, 255)
    )),

    VIRIDIS(List.of(
            new Color(68, 1, 84),
            new Color(65, 28, 102),
            new Color(62, 55, 121),
            new Color(59, 82, 139),
            new Color(46, 114, 140),
            new Color(33, 145, 140),
            new Color(64, 173, 119),
            new Color(94, 201, 98),
            new Color(174, 216, 68),
            new Color(253, 231, 37)
    )),

    MAGMA(List.of(
            new Color(0, 0, 4),
            new Color(27, 6, 44),
            new Color(54, 12, 84),
            new Color(81, 18, 124),
            new Color(132, 36, 122),
            new Color(183, 55, 121),
            new Color(218, 96, 109),
            new Color(252, 137, 97),
            new Color(252, 195, 144),
            new Color(252, 253, 191)
    )),

    PLASMA(List.of(
            new Color(13, 8, 135),
            new Color(51, 6, 146),
            new Color(88, 5, 157),
            new Color(126, 3, 168),
            new Color(165, 37, 144),
            new Color(204, 71, 120),
            new Color(226, 110, 92),
            new Color(248, 149, 64),
            new Color(244, 199, 48),
            new Color(240, 249, 33)
    )),

    INFERNO(List.of(
            new Color(0, 0, 4),
            new Color(29, 5, 39),
            new Color(58, 11, 75),
            new Color(87, 16, 110),
            new Color(138, 36, 97),
            new Color(188, 55, 84),
            new Color(218, 98, 46),
            new Color(249, 142, 9),
            new Color(250, 198, 86),
            new Color(252, 255, 164)
    )),

    TWILIGHT(List.of(
            new Color(226, 217, 226),
            new Color(178, 186, 208),
            new Color(131, 156, 190),
            new Color(116, 108, 175),
            new Color(100, 60, 160),
            new Color(80, 40, 115),
            new Color(60, 20, 70),
            new Color(110, 45, 80),
            new Color(160, 70, 90),
            new Color(226, 217, 226)
    )),

    MINT_CHOCOLATE(List.of(
            new Color(25, 15, 10),          // Chocolat noir profond (fond)
            new Color(48, 28, 18),
            new Color(70, 40, 25),          // Marron chocolat
            new Color(50, 65, 48),
            new Color(30, 90, 70),          // Menthe sombre
            new Color(52, 135, 108),
            new Color(75, 180, 145),        // Vert menthe doux
            new Color(112, 210, 178),
            new Color(150, 240, 210),       // Menthe glacée
            new Color(230, 255, 245)        // Blanc mentholé
    ));

    private final List<Color> colors;

    ColorPalette(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }

    /**
     * Récupère le nombre de couleurs contenues dans la palette.
     */
    public int size() {
        return colors.size();
    }

    /**
     * Récupère directement la i-ème couleur.
     */
    public Color getColor(int index) {
        return colors.get(index % colors.size());
    }
}
