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


## Contribute
If you want to contribute to this library, you're always welcome!
See [Contributing Guidelines](CONTRIBUTING.md). 

## License
```
MIT License

Copyright (c) 2023 Ashutosh Wahane

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
