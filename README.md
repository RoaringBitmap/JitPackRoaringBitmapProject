## MavenRoaringBitmapProject

This is a demonstration of how to use the RoaringBitmap library from a
GitHub package.

- [Maven](#maven)
- [Gradle](#gradle)


## Maven

Add the following dependency to your pom.xml file...

```xml
    <dependency>
      <groupId>org.roaringbitmap</groupId>
      <artifactId>roaringbitmap</artifactId>
      <version>1.3.12</version>
    </dependency>
```

You may adjust the version number.

Then add the repository to your pom.xml file:

```xml
<repositories>
    <repository>
        <id>github</id>
        <name>Roaring Maven Packages</name>
        <url>https://maven.pkg.github.com/RoaringBitmap/RoaringBitmap</url>
        <releases><enabled>true</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
```

See our pom.xml file as an example.

The registry access is is protected by an authorisation. So you have to add your GitHub credentials to your global settings.xml: `$HOME\.m2\settings.xml`.

You will need a token which you can generate on GitHub.

```
GitHub > Settings > Developer Settings > Personal access tokens > Generate new token
```

The token needs the read:packages permission. The token identifier is a long string such as `ghp_ieO----------kN`.

Then put the following in your `settings.xml` file, within the `<servers>` element.

```xml
<server>
  <id>github</id>
  <username>lemire</username>
  <password>ghp_ieO----------kN</password>
</server>
```

Replace `lemire` by your GitHub username and `ghp_ieO----------kN` by the token identifier
you just generated.

## Gradle

The approach with gradle is similar. You still need your GitHub credentials. Go
to 

```
GitHub > Settings > Developer Settings > Personal access tokens > Generate new token
```

And create a token with read:packages permission.

If your GitHub user name is `lemire` and your GitHub personal token `ghp_ieOkN`,
then you can set them using system variables. Under bash, you can do it like so:
```
export GITHUB_USER=lemire
export GITHUB_PASSWORD=ghp_ieOkN
```


If you prefer you can write your GitHub credentials in your  gradle.properties
file

```
# gradle.properties
githubUser=lemire
githubPassword=ghp_ieOkN
```

Then all you need is the following `build.gradle` file:

```groovy
plugins {
    id 'java'
}

group 'org.roaringbitmap' // name of your project
version '1.0-SNAPSHOT' // version of your project

repositories {
    mavenCentral()
    maven {
        url 'https://maven.pkg.github.com/RoaringBitmap/RoaringBitmap'
        credentials {
            username = System.properties['githubUser'] ?: System.env.GITHUB_USER
            password = System.properties['githubPassword'] ?: System.env.GITHUB_PASSWORD
        }
    }
}

dependencies {
    implementation 'org.roaringbitmap:roaringbitmap:1.3.12'
    testImplementation 'junit:junit:3.8.1'
}
```
