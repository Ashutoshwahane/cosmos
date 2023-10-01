![](/readme_img/Cosmos.png)

# [COSMOS](https://github.com/Ashutoshwahane/cosmos) is a space science app Built using [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)

![](readme_images/logo_screenshot.png)

## Purpose
* To Explore Kotlin Multiplatform.
* Code Reusability -> Kotlin Multiplatform is the ability to write shared code that can be used across different platforms, such as Android, iOS, and even web applications.
* Faster Development -> With code sharing, you can iterate faster and release updates more quickly for multiple platforms. This can be especially useful if you're working on a product that needs to be available on both Android and iOS.
* Community and Industry Trends -> Kotlin Multiplatform is gaining traction in the industry, and as more companies adopt it, having knowledge in this area can make you a more attractive candidate for job opportunities

### Environment setup

You need to supply keys for Nasa API. You can find information about how to gain access by using the [link](https://api.nasa.gov/).

When you obtain the keys, you can provide them to the app by putting the following in the `local.properties` project root file:
```properties
#Nasa API KEYS
API_KEY = "<insert>"
```


## Built with 

- [Kotlin](kotlinlang.org): Programming language
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html): For building multi-platform applications in the single codebase.
- Used Jetbrain multiplatform template to create the project [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform#readme).
  - [Coroutines](https://github.com/Kotlin/kotlinx.coroutines): For multithreading
  - [Serialization](https://github.com/Kotlin/kotlinx.serialization): For JSON serialization/deserailization
- [Ktor Client](https://github.com/ktorio/ktor): Performing HTTP requests, Creating image loading utility for iOS module.
- [Coil](https://github.com/coil-kt/coil): Image loading for Android

* Found issues, please report them on [GitHub](https://github.com/Ashutoshwahane/cosmos/issues).
