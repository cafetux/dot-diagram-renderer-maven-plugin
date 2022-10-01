# Maven Plugin to render DOT diagram as PNG

Just a maven plugin that embed a dot2png rendition library into maven plugin.


## Usage

Plugin render all .gv files present into parsingDirectory png.


### import project
Project is not into maven central or another repository.
So you need to build them by yourself.

If you are into compay that have security policies that block jitpack, you need to build this library too:
https://github.com/cafetux/dot-diagram-to-picture

And change the pom to import them without jitpack.

### Usage in pom
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>com.livido</groupId>
                <artifactId>maven-dot-to-png-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
                <configuration>
                    <resultDirectory>target/png</resultDirectory>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>dot-to-png</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

```

### Parameters

```xml
    <configuration>
        <parsingDirectory>directory to parse</parsingDirectory>
        <resultDirectory>directory to write results</resultDirectory>
    </configuration>
```

or use -Dgraph.dot2png.resultDirectory and -Dgraph.dot2png.parsingDirectory
