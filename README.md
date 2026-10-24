# FractaLens - A Fractal Generator Library Developed in Lens.

This project provides a *Java* library for generating fractal images.
It allows users to choose from a variety of complex sequences, including the
Julia set, Mandelbrot set, and other generalized sequences, to create
static or animated fractal images using different color palettes and
transformations.

## Overview

This library is composed of the following classes:

```plantuml
hide empty members

' --------------- '
' Complex Numbers '
' --------------- '

interface IComplex {
    + {abstract} getRealPart() : double
    + {abstract} getImaginaryPart() : double
    + {abstract} abs() : double
    + {abstract} negate() : IComplex
    + {abstract} conjugate() : IComplex
    + {abstract} add(other : IComplex) : IComplex
    + {abstract} subtract(other : IComplex) : IComplex
    + {abstract} multiply(value : double) : IComplex
    + {abstract} multiply(other : IComplex) : IComplex
    + {abstract} divide(other : IComplex) : IComplex
    + {abstract} power(power : int) : IComplex
}

class Complex implements IComplex {
    - a : double
    - b : double
    + Complex(a : double, b : double)
}

interface IComplexPlane {
    + {abstract} asComplex(row : int, column : int) : IComplex
}

class ComplexPlane implements IComplexPlane {
    - width : int
    - height : int
    + ComplexPlane(width : int, height : int)
}

class ZoomComplexPlane implements IComplexPlane {
    - zoom : double
    + ZoomComplexPlane(decorated : IComplexPlane, zoom : double)
}

class TranslateComplexPlane implements IComplexPlane {
    + TranslateComplexPlane(decorated : IComplexPlane, complexNumber : IComplex)
}

IComplexPlane --> IComplex : << creates >>
ZoomComplexPlane --> "1" IComplexPlane : decorated
TranslateComplexPlane --> "1" IComplexPlane : decorated
TranslateComplexPlane --> "1" IComplex : translation
ComplexPlane ..> Complex : << creates >>

' ----------------- '
' Complex Sequences '
' ----------------- '

interface IComplexSequence extends Iterable<IComplex> {
    + {abstract} computeNext(previous : IComplex) : IComplex
    + {abstract} iterator() : Iterator<IComplex>
}

class ComplexSequence implements Iterator<IComplex> {
    - maxIterations : int
    - nbIterations : int
    + ComplexSequence(sequence : IComplexSequence, initialValue : IComplex, maxIterations : int)
    + hasNext() : boolean
    + next() : IComplex
}

class JuliaSequence implements IComplexSequence {
    + JuliaSequence(c : IComplex, z0 : IComplex, maxIterations : int)
}

class GeneralizedJulia implements IComplexSequence {
    - p : int
    + GeneralizedJulia(c : IComplex, z0 : IComplex, maxIterations : int, p : int)
}

class Mandelbrot implements IComplexSequence {
    - power : int
    + Mandelbrot(c : IComplex, z0 : IComplex, maxIterations : int, power : int)
    + getC() : IComplex
}

class BurningShipSequence implements IComplexSequence {
    + BurningShipSequence(c : IComplex, z0 : IComplex, maxIterations : int)
}

class GeneralComplexSequence implements IComplexSequence {
    - function : BinaryOperator<IComplex>
    + GeneralComplexSequence(function : BinaryOperator<IComplex>, z0 : IComplex, max : int)
}

enum EnumSequence {
    MANDELBROT
    GENERALIZED_JULIA
    GENERALIZED_MANDELBROT
    BURNING_SHIP
    GENERALIZED_BURNING_SHIP
    TRICORN
    GENERALIZED_TRICORN
    + create(pixel : IComplex, maxIterations : int) : IComplexSequence
}

IComplexSequence --> IComplex : << generates >>
IComplexSequence ..> ComplexSequence : << creates >>
ComplexSequence --> "1" IComplexSequence : sequence
EnumSequence ..> IComplexSequence : << creates >>
EnumSequence ..> Mandelbrot : << creates >>
EnumSequence ..> GeneralizedJulia : << creates >>
EnumSequence ..> BurningShipSequence : << creates >>
EnumSequence ..> GeneralComplexSequence : << creates >>

' --------------- '
' Color Handling  '
' --------------- '

interface IColor {
    + {abstract} coloredDot(iteration : int, max : int) : Color
}

class ColoredGrey implements IColor

class ColoredGradient implements IColor {
    + ColoredGradient(firstColor : Color, secondColor : Color)
}

class ColoredFixe implements IColor {
    + ColoredFixe(palette : ColorPalette)
    + ColoredFixe(colors : List<Color>)
}

class ColoredRVB implements IColor {
    + ColoredRVB(decor : IColor, redFactor : double, greenFactor : double, blueFactor : double)
}

class ColoredInverse implements IColor {
    + ColoredInverse(decor : IColor)
}

enum ColorPalette {
    FIRE
    OCEAN
    RAINBOW
    VIRIDIS
    ...
    + getColors() : List<Color>
    + size() : int
    + getColor(index : int) : Color
}

enum EnumPalette {
    FIRE
    OCEAN
    RAINBOW
    VIRIDIS
    ...
    RVB_CUSTOM
    + create(paletteSize : int) : IColor
}

ColoredRVB --> "1" IColor : decor
ColoredInverse --> "1" IColor : decor
ColoredFixe --> ColorPalette : << uses >>
EnumPalette ..> IColor : << creates >>
EnumPalette ..> ColoredFixe : << creates >>
EnumPalette ..> ColoredRVB : << creates >>

' -------------- '
' Image Handling '
' -------------- '

interface IFractalImage {
    + {abstract} getHeight() : int
    + {abstract} getWidth() : int
    + {abstract} setColor(row : int, column : int, color : Color) : void
    + {abstract} saveAs(path : String) : void
    + {abstract} asBufferedImage() : BufferedImage
}

class FractalImage implements IFractalImage {
    + FractalImage(img : BufferedImage)
}

FractalImage --> "1" BufferedImage : adapts

' ------------------ '
' Fractal Generation '
' ------------------ '

interface IFractalGenerator {
    + {abstract} generateImage() : IFractalImage
    + {abstract} computePixelColor(row : int, column : int) : Color
    + {abstract} saveImage() : void
}

class FractalGenerator implements IFractalGenerator {
    - maxIterations : int
    - outputPath : String
    + FractalGenerator(builder : FractalGeneratorBuilder)
}

class FractalImageComposite implements IFractalGenerator {
    - outputPath : String
    + FractalImageComposite(generators : List<IFractalGenerator>, outputPath : String)
}

class FractalGeneratorBuilder {
    - width : int
    - height : int
    - zoomFactor : double
    - maxIterations : int
    - fileName : String
    + withSize(width : int, height : int) : FractalGeneratorBuilder
    + withZoom(zoomFactor : double) : FractalGeneratorBuilder
    + withTranslation(translation : IComplex) : FractalGeneratorBuilder
    + centeredAt(center : IComplex) : FractalGeneratorBuilder
    + withMaxIterations(maxIterations : int) : FractalGeneratorBuilder
    + usingSequence(sequence : EnumSequence) : FractalGeneratorBuilder
    + usingSequence(function : BiFunction<IComplex, Integer, IComplexSequence>) : FractalGeneratorBuilder
    + usingPalette(palette : EnumPalette) : FractalGeneratorBuilder
    + usingPalette(palette : IColor) : FractalGeneratorBuilder
    + outputToFile(fileName : String) : FractalGeneratorBuilder
    + build() : FractalGenerator
    + buildZoomAnimation(nbFrames : int, zoomFactorStep : double) : IFractalGenerator
    + buildJuliaRotationAnimation(initialC : IComplex, nbFrames : int) : IFractalGenerator
    + getImage() : IFractalImage
    + getPlane() : IComplexPlane
}

class AnimatedGifEncoder <<external library>>

IFractalGenerator --> IFractalImage : << produces >>
IFractalGenerator --> IComplexSequence : << uses >>

FractalGenerator --> "1" IFractalImage : image
FractalGenerator --> "1" IComplexPlane : plane
FractalGenerator --> "1" IColor : palette
FractalGenerator ..> IComplexSequence : << uses >>
FractalGenerator ..> FractalGeneratorBuilder : << reads >>

FractalImageComposite o--> "*" IFractalGenerator : generators
FractalImageComposite ..> AnimatedGifEncoder : << uses >>

FractalGeneratorBuilder ..> FractalGenerator : << creates >>
FractalGeneratorBuilder ..> FractalImageComposite : << creates >>
FractalGeneratorBuilder ..> FractalImage : << creates >>
FractalGeneratorBuilder ..> ComplexPlane : << creates >>
FractalGeneratorBuilder ..> ZoomComplexPlane : << creates >>
FractalGeneratorBuilder ..> TranslateComplexPlane : << creates >>
FractalGeneratorBuilder ..> JuliaSequence : << creates >>
FractalGeneratorBuilder --> EnumSequence : << uses >>
FractalGeneratorBuilder --> EnumPalette : << uses >>
FractalGeneratorBuilder --> IColor : palette

' ---- '
' Main '
' ---- '

class Main {
    + {static} main(args : String[]) : void
}

Main ..> FractalGeneratorBuilder : << uses >>
```

## Feature list

| Features                                               | Design Pattern(s) (?) | Author(s) |
|--------------------------------------------------------|-----------------------|-----------|
| Complex number                                         | None                  | Tom       |
| Default complex plane                                  | Decorator             | Hugo      |
| Scaled complex plane                                   | Decorator             | Hugo      |
| Translated complex plane                               | Decorator             | Hugo      |
| Sequence of complex numbers                            | Strategy              | Tom       |
| Iterator over a sequence of complex numbers            | Iterator              | Hugo      |
| Julia sequence                                         | Strategy              | Eva       |
| Mandelbrot sequence                                    | Strategy              | Hugo      |
| Multijulia sequence                                    | Strategy              | Eva       |
| Multibrot sequence                                     | Strategy              | Louis     |
| Generic sequences                                      | Strategy              | Hugo      |
| Color palette                                          | Strategy              | Tom       |
| Grey scale palette                                     | Strategy              | Eva       |
| Red/Green/Blue/... scale palette                       | Decorator             | Tom       |
| Inverted color palette                                 | Decorator             | Eva       |
| Gradient-based color palette                           | Strategy              | Louis     |
| Predefined color palette                               | Factory               | Louis     |
| `BufferedImage` used as an `IFractalImage`             | Adapter               | Tom       |
| Static image generation                                | Composite             | Tom       |
| Scale-based animated image generation                  | Composite             | Louis     |
| Rotation-based animated image generation               | Composite             | Eva       |
| Configuration of the fractal generator                 | Builder               | Hugo      |
| Command-line interface                                 | None                  | Louis     |

## Team

This project has been developed by:

- Deleau Tom
- Dunocq Louis
- Halipre Hugo
- Nys Eva 

## Guide d'utilisation


**Zoom lourd**
```bash
./gradlew run --args="-t zoom -f mandelbrot -p magma -n 1500 -w 500 -h 500 -s 0.01 --focus-x=-0.743643887 --focus-y=0.131825904 --frames 150 --zoom-step 0.92 -o mandelbrot_50mo.gif"
```

**Aide**
```bash
./gradlew run --args="--help"
```

**Version** (le `-V` est conservé, `--version` aussi)
```bash
./gradlew run --args="--version"
```

**Valeurs par défaut**
```bash
./gradlew run
```

**Mandelbrot classique, palette feu**
```bash
./gradlew run --args="-f mandelbrot -p fire -n 250 --focus-x=-0.75 -o mandelbrot.png"
```

**Burning Ship, zoomé sur la proue**
```bash
./gradlew run --args="-f burning_ship -p fire -w 800 -h 800 -n 64 -s 0.00015 --focus-x=-1.755 --focus-y=-0.03 -o burningship.png"
```

**Julia généralisée**
```bash
./gradlew run --args="-f generalized_julia -p galaxy -w 800 -h 800 -n 300 -s 0.004 -o julia_gen.png"
```

**Tricorn**
```bash
./gradlew run --args="-f tricorn -p neon -n 150 -s 0.008 -o tricorn.png"
```

**Zoom dans la vallée des hippocampes**
```bash
./gradlew run --args="-t zoom -f mandelbrot -p fire -n 250 -s 0.01 --focus-x=-0.743643887 --focus-y=0.131825904 --frames 40 --zoom-step 0.8 -o zoom.gif"
```
**Rotation de la constante de Julia**
```bash
./gradlew run --args="-t rotation -p cyberpunk -n 150 -s 0.01 --frames 60 -o julia_rotation.gif"
```
