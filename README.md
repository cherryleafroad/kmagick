# KMagick

ImageMagick bindings for Kotlin; uses the ImageMagick wand API.

## Supported Platforms
Windows and Android*

\* Others may work too, but I have not tested Mac or Linux.

## Setup
You can find binary releases in the release section.

### Android
1. Grab the jar and sources jar and put it in your project.
2. Add this line to your dependencies: `implementation fileTree(dir: 'libs', include: ['*.jar'])`
3. Place the jars in the `app/libs` folder.
4. Place ImageMagick shared so files in your `app/src/main/jniLibs` folder along with the Android `kmagick.so` library in the download section.

\* I plan to add a Maven config sometime, but I've been too busy and tired.

### Windows
1. Grab the `kmagick.dll` file along with the jar and sources jar.
2. Install Windows ImageMagick (dll version) and make sure the program files folder is in your `PATH`.
3. Setup your project to use the jar as normal.
4. Make sure `kmagick.dll` is in your path as well.

## API and Examples
First of all, check out the official [ImageMagick](https://imagemagick.org/script/magick-wand.php) function reference. If you have any confusion/questions, it'll be answered there. Also, the sources jar contains comments for every function which should be good enough in most cases.

There's an example under the `example` directory as well.
```kotlin
// Basic usage

// You MUST call Magick.initialize() before you can use the library.
Magick.initialize()

// You can also use this with a `use` block to automatically terminate at the end
Magick.initialize().use {
  // do your stuff
}

// when you're done, you should call terminate. The `use` block above does that automatically for you.
// Note: When you call this, ALL your wands will immediately be invalidated at the C level.
// DO NOT attempt to use them after or you'll get an exception.
Magick.terminate()

Magick.initialize().use {
  val a = PixelWand()
  a.color = "blue"
  
  val b = MagickWand()
  b.newImage(100, 200, a)
}
```
