package com.cherryleafroad.kmagick

class DrawingWandException(message: String) : MagickException(message)

/**
 * DrawingWand API. For drawing things on the image (such as text).
 */
@Suppress("unused", "MemberVisibilityCanBePrivate")
@kotlin.ExperimentalUnsignedTypes
class DrawingWand {
    init {
        new()
    }

    /**
     * Holds the pointer to internal object in memory.
     */
    private var handle: Long? = null

    /**
     * Create a new DrawingWand.
     */
    private external fun new()

    /**
     * Verifies whether this is a DrawingWand.
     *
     * @return Whether this is a verified DrawingWand.
     */
    @Throws(DrawingWandException::class)
    external fun isWand(): Boolean

    /**
     * Clone the wand into a new one.
     *
     * @return The cloned DrawingWand.
     */
    @Throws(DrawingWandException::class)
    external fun clone(): DrawingWand

    /**
     * Clear the wand contents.
     */
    @Throws(DrawingWandException::class)
    external fun clear()

    /**
     * While this automatically gets called by the `finalize()` destructor,
     * `finalize()` is not guaranteed to be called at all, nor called on time.
     * It's recommended to manually destroy all wands when finished.
     */
    external fun destroy()

    /**
     * While this is here to automatically call the destructor, due to
     * the way Kotlin/Java works, it's not guaranteed to be called at all,
     * or called on time. It is not recommended relying on this to destroy
     * the wand consistently/timely.
     */
    protected fun finalize() {
        destroy()
    }

    /**
     * Draws text on the image.
     *
     * @param x The x ordinate to left of text.
     * @param y The y ordinate to text baseline.
     * @param text The text to draw.
     */
    @Throws(DrawingWandException::class)
    external fun drawAnnotation(x: Double, y: Double, text: String)

    /**
     * The fully-specified font used when annotating with text.
     */
    var font: String
        get() = drawGetFont()
        set(value) = drawSetFont(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFont(): String
    @Throws(DrawingWandException::class)
    private external fun drawSetFont(fontName: String)

    /**
     * The font family to use when annotating with text.
     */
    var fontFamily: String
        get() = drawGetFontFamily()
        set(value) = drawSetFontFamily(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFontFamily(): String
    @Throws(DrawingWandException::class)
    private external fun drawSetFontFamily(fontFamily: String)

    /**
     * The vector graphics generated by any graphics calls made since the wand was instantiated.
     * Setting will set the vector graphics associated with the specified wand using the specified DrawingWand XML.
     * Use this method with `DrawGetVectorGraphics()` as a method to persist the vector graphics state.
     */
    var vectorGraphics: String
        get() = drawGetVectorGraphics()
        set(value) = drawSetVectorGraphics(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetVectorGraphics(): String
    @Throws(DrawingWandException::class)
    private external fun drawSetVectorGraphics(xml: String)

    /**
     * The current (named) clipping path ID associated with the image.
     * Only the areas drawn on by the clipping path will be modified as ssize_t as it remains in effect.
     */
    var clipPath: String
        get() = drawGetClipPath()
        set(value) = drawSetClipPath(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetClipPath(): String
    @Throws(DrawingWandException::class)
    private external fun drawSetClipPath(clipMask: String)

    /**
     * The code set used for text annotations. The only character encoding which may be specified at
     * this time is "UTF-8" for representing Unicode as a sequence of bytes. Specify an empty string to set text
     * encoding to the system's default. Successful text annotation using Unicode may require fonts designed to
     * support Unicode.
     */
    var textEncoding: String
        get() = drawGetTextEncoding()
        set(value) = drawSetTextEncoding(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextEncoding(): String
    @Throws(DrawingWandException::class)
    private external fun drawSetTextEncoding(encoding: String)

    /**
     * The border color used for drawing bordered objects.
     */
    var borderColor: PixelWand
        get() = drawGetBorderColor()
        set(value) = drawSetBorderColor(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetBorderColor(): PixelWand
    @Throws(DrawingWandException::class)
    private external fun drawSetBorderColor(borderWand: PixelWand)

    /**
     * The fill color used for drawing filled objects.
     */
    var fillColor: PixelWand
        get() = drawGetFillColor()
        set(value) = drawSetFillColor(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFillColor(): PixelWand
    @Throws(DrawingWandException::class)
    private external fun drawSetFillColor(fillWand: PixelWand)

    /**
     * The color used for stroking object outlines.
     */
    var strokeColor: PixelWand
        get() = drawGetStrokeColor()
        set(value) = drawSetStrokeColor(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeColor(): PixelWand
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeColor(strokeWand: PixelWand)

    /**
     * The color of a background rectangle to place under text annotations.
     *
     * @return The undercolor.
     */
    var textUnderColor: PixelWand
        get() = drawGetTextUnderColor()
        set(value) = drawSetTextUnderColor(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextUnderColor(): PixelWand
    @Throws(DrawingWandException::class)
    private external fun drawSetTextUnderColor(underWand: PixelWand)

    /**
     * The text placement gravity used when annotating with text.
     */
    var gravity: GravityType
        get() = drawGetGravity()
        set(value) = drawSetGravity(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetGravity(): GravityType
    @Throws(DrawingWandException::class)
    private external fun drawSetGravity(gravity: GravityType)

    /**
     * The alpha used when drawing with the fill or stroke color or texture. Fully opaque is 1.0.
     */
    var opacity: Double
        get() = drawGetOpacity()
        set(value) = drawSetOpacity(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetOpacity(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetOpacity(opacity: Double)

    /**
     * The current polygon fill rule to be used by the clipping path.
     */
    var clipRule: FillRule
        get() = drawGetClipRule()
        set(value) = drawSetClipRule(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetClipRule(): FillRule
    @Throws(DrawingWandException::class)
    private external fun drawSetClipRule(fillRule: FillRule)

    /**
     * The interpretation of clip path units.
     */
    var clipUnits: ClipPathUnits
        get() = drawGetClipUnits()
        set(value) = drawSetClipUnits(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetClipUnits(): ClipPathUnits
    @Throws(DrawingWandException::class)
    private external fun drawSetClipUnits(clipUnits: ClipPathUnits)

    /**
     * The fill rule used while drawing polygons.
     */
    var fillRule: FillRule
        get() = drawGetFillRule()
        set(value) = drawSetFillRule(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFillRule(): FillRule
    @Throws(DrawingWandException::class)
    private external fun drawSetFillRule(fillRule: FillRule)

    /**
     * The alpha used when drawing using the fill color or fill texture. Fully opaque is 1.0.
     */
    var fillOpacity: Double
        get() = drawGetFillOpacity()
        set(value) = drawSetFillOpacity(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFillOpacity(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetFillOpacity(fillOpacity: Double)

    /**
     * The font pointsize used when annotating with text.
     */
    var fontSize: Double
        get() = drawGetFontSize()
        set(value) = drawSetFontSize(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFontSize(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetFontSize(pointSize: Double)

    /**
     * The font style used when annotating with text. The AnyStyle enumeration acts as a wild-card "don't care"
     * option.
     */
    var fontStyle: StyleType
        get() = drawGetFontStyle()
        set(value) = drawSetFontStyle(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFontStyle(): StyleType
    @Throws(DrawingWandException::class)
    private external fun drawSetFontStyle(style: StyleType)

    /**
     * The font weight used when annotating with text. Font weight valid range: 100-900
     */
    var fontWeight: ULong
        get() = drawGetFontWeight()
        set(value) = drawSetFontWeight(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFontWeight(): ULong
    @Throws(DrawingWandException::class)
    private external fun drawSetFontWeight(fontWeight: ULong)

    /**
     * The font stretch used when annotating with text. The AnyStretch enumeration acts as a wild-card.
     */
    var fontStretch: StretchType
        get() = drawGetFontStretch()
        set(value) = drawSetFontStretch(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetFontStretch(): StretchType
    @Throws(DrawingWandException::class)
    private external fun drawSetFontStretch(fontStretch: StretchType)

    /**
     * The offset into the dash pattern to start the dash.
     */
    var strokeDashOffset: Double
        get() = drawGetStrokeDashOffset()
        set(value) = drawSetStrokeDashOffset(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeDashOffset(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeDashOffset(dashOffset: Double)

    /**
     * The shape to be used at the end of open subpaths when they are stroked.
     */
    var strokeLineCap: LineCap
        get() = drawGetStrokeLineCap()
        set(value) = drawSetStrokeLineCap(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeLineCap(): LineCap
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeLineCap(lineCap: LineCap)

    /**
     * The shape to be used at the corners of paths (or other vector shapes) when they are stroked.
     */
    var strokeLineJoin: LineJoin
        get() = drawGetStrokeLineJoin()
        set(value) = drawSetStrokeLineJoin(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeLineJoin(): LineJoin
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeLineJoin(lineJoin: LineJoin)

    /**
     * The miter limit. When two line segments meet at a sharp angle and miter joins have been specified for `lineJoin`,
     * it is possible for the miter to extend far beyond the thickness of the line stroking the path. The miterLimit
     * imposes a limit on the ratio of the miter length to the `lineWidth`.
     */
    var strokeMiterLimit: ULong
        get() = drawGetStrokeMiterLimit()
        set(value) = drawSetStrokeMiterLimit(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeMiterLimit(): ULong
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeMiterLimit(miterLimit: ULong)

    /**
     * The alpha of stroked object outlines. The value 1.0 is opaque.
     */
    var strokeOpacity: Double
        get() = drawGetStrokeOpacity()
        set(value) = drawSetStrokeOpacity(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeOpacity(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeOpacity(opacity: Double)

    /**
     * The width of the stroke used to draw object outlines.
     */
    var strokeWidth: Double
        get() = drawGetStrokeWidth()
        set(value) = drawSetStrokeWidth(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeWidth(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeWidth(strokeWidth: Double)

    /**
     * The current stroke antialias setting. Stroked outlines are antialiased by default. When antialiasing is disabled
     * stroked pixels are thresholded to determine if the stroke color or underlying canvas color should be used.
     * Set to false to disable antialiasing.
     */
    var strokeAntialias: Boolean
        get() = drawGetStrokeAntialias()
        set(value) = drawSetStrokeAntialias(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetStrokeAntialias(): Boolean
    @Throws(DrawingWandException::class)
    private external fun drawSetStrokeAntialias(strokeAntialias: Boolean)

    /**
     * The alignment applied when annotating with text.
     */
    var textAlignment: AlignType
        get() = drawGetTextAlignment()
        set(value) = drawSetTextAlignment(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextAlignment(): AlignType
    @Throws(DrawingWandException::class)
    private external fun drawSetTextAlignment(alignment: AlignType)

    /**
     * The current text antialias setting, which determines whether text is antialiased. Text is antialiased by default.
     * Set to false to disable antialiasing.
     */
    var textAntialias: Boolean
        get() = drawGetTextAntialias()
        set(value) = drawSetTextAntialias(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextAntialias(): Boolean
    @Throws(DrawingWandException::class)
    private external fun drawSetTextAntialias(textAntialias: Boolean)

    /**
     * The decoration applied when annotating with text.
     */
    var textDecoration: DecorationType
        get() = drawGetTextDecoration()
        set(value) = drawSetTextDecoration(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextDecoration(): DecorationType
    @Throws(DrawingWandException::class)
    private external fun drawSetTextDecoration(decoration: DecorationType)

    /**
     * The direction that will be used when annotating with text.
     */
    var textDirection: DirectionType
        get() = drawGetTextDirection()
        set(value) = drawSetTextDirection(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextDirection(): DirectionType
    @Throws(DrawingWandException::class)
    private external fun drawSetTextDirection(direction: DirectionType)

    /**
     * The spacing between characters in text.
     */
    var textKerning: Double
        get() = drawGetTextKerning()
        set(value) = drawSetTextKerning(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextKerning(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetTextKerning(kerning: Double)

    /**
     * The spacing between line in text.
     */
    var textInterlineSpacing: Double
        get() = drawGetTextInterlineSpacing()
        set(value) = drawSetTextInterlineSpacing(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextInterlineSpacing(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetTextInterlineSpacing(interlineSpacing: Double)

    /**
     * The spacing between words in text.
     */
    var textInterwordSpacing: Double
        get() = drawGetTextInterwordSpacing()
        set(value) = drawSetTextInterwordSpacing(value)
    @Throws(DrawingWandException::class)
    private external fun drawGetTextInterwordSpacing(): Double
    @Throws(DrawingWandException::class)
    private external fun drawSetTextInterwordSpacing(interwordSpacing: Double)
}
