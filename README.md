## JitPackRoaringBitmapProject
[![11, 17, 21 CI](https://github.com/RoaringBitmap/JitPackRoaringBitmapProject/actions/workflows/allversions.yml/badge.svg)](https://github.com/RoaringBitmap/JitPackRoaringBitmapProject/actions/workflows/allversions.yml)

This is a demonstration of how to use the RoaringBitmap library from JitPack.

- [Maven](#maven)
- [Gradle](#gradle)


## Maven

Add the following dependency to your pom.xml file...

```xml
<dependency>
    <groupId>com.github.RoaringBitmap.RoaringBitmap</groupId>
    <artifactId>roaringbitmap</artifactId>
    <version>1.3.16</version>
</dependency>
```

You may adjust the version number.

Then add the repository to your pom.xml file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
     </repository>
</repositories>
```

## Gradle

The approach with gradle is similar.

All you need is to edit your `build.gradle` file like so:

```groovy
plugins {
    id 'java'
}

group 'org.roaringbitmap' // name of your project
version '1.0-SNAPSHOT' // version of your project

repositories {
    mavenCentral()
    maven {
        url 'https://jitpack.io'
    }
}

dependencies {
    implementation 'com.github.RoaringBitmap.RoaringBitmap:roaringbitmap:1.3.16'
    testImplementation 'junit:junit:3.8.1'
}
```
