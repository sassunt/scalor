# scalor

You can print colorful text fluently.
Scalor has useful coloring fanctions that makes it easy to convert arguments into an ANSI escape sequence.
You can include scalor to your own product easily.

## Install
Add the following to your sbt build definition:

```
libraryDependencies += "com.github.sassunt" % "scalor" % "0.1.0"
```

## Usage

First, You need to import follows:

```
import com.github.sassunt.scalor.ansi._ // Required
import Colors._                         // Optional
import Tones._                          // Optional
```

#### text color :

    "scalor-string" :# red

or

    "scalor-string".:#[Red]

#### background color :

    "scalor-string" :~ yellow

or

    "scalor-string".:~[Yellow]

#### color tone :

    "scalaor-string" :# red :@ bright

or

    "scalaor-string".:#[Red].:@[Bright]

#### bold :

    "scalor-string" :@ bold

or

    "scalor-string".:@[Bold]



## example

![sample terminal](https://raw.github.com/sassunt/scalor/master/docs/img/scalor_example.png)


## License
Apache License, Version 2.0

[http://www.apache.org/licenses/LICENSE-2.0.html](http://www.apache.org/licenses/LICENSE-2.0.html)
