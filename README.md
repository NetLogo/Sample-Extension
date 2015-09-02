# NetLogo sample extension

This is a very small example NetLogo extension, written in Java.

## Building

Use the netlogo.jar.url environment variable to tell sbt which NetLogo.jar to compile against (defaults to NetLogo 5.3). For example:

    sbt -Dnetlogo.jar.url=file:///path/to/NetLogo/target/NetLogo.jar package

If compilation succeeds, `sample.jar` will be created.

## Terms of Use

[![CC0](http://i.creativecommons.org/p/zero/1.0/88x31.png)](http://creativecommons.org/publicdomain/zero/1.0/)

The NetLogo sample extension is in the public domain.  To the extent possible under law, Uri Wilensky has waived all copyright and related or neighboring rights.
