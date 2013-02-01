# scalor

ANSI color

## sbt
scala version 2.9.2 or 2.10.0

    libraryDependencies += "com.github.sassunt" %% "scalor" % "0.1.0"

## usage

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

