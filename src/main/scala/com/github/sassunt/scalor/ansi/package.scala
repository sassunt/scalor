package com.github.sassunt.scalor

package object ansi {

  implicit object AnsiDefaultFontParams extends FontParams(Colors.default, Tones.plain, Colors.default, List(Colors.default), Colors.reset, enableScalor)
}
