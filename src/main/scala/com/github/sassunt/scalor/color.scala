package com.github.sassunt.scalor

sealed trait Color {
  import Tones._

  val fgPlain: String
  val fgBright: String
  val fgDark: String

  def apply(txt: String)(implicit default: FontParams): Font[Painted] = Font(txt)(default) :# this
  def apply(tone: Tone): String = {
    tone match {
      case `plain`  => fgPlain
      case `bright` => fgBright
      case `dark`   => fgDark
    }
  }
}

object Tones {
  case object plain extends Tone
  case object dark extends Tone
  case object bright extends Tone
}

sealed private[scalor] trait BgColor {
  val bgPlain: String
}

sealed private[scalor] trait Decor {
  val decor: String
}

private[scalor] trait Reset {
  val reset: String
}

sealed private[scalor] trait Tone

private[scalor] trait Colors {
  protected[Colors] trait Black extends Color with BgColor
  protected[Colors] trait Blue extends Color with BgColor
  protected[Colors] trait Cyan extends Color with BgColor
  protected[Colors] trait Green extends Color with BgColor
  protected[Colors] trait Magenta extends Color with BgColor
  protected[Colors] trait Red extends Color with BgColor
  protected[Colors] trait White extends Color with BgColor
  protected[Colors] trait Yellow extends Color with BgColor
  protected[Colors] trait Default extends Color with BgColor with Decor

  protected[Colors] trait Bold extends Decor
  protected[Colors] trait Underline extends Decor

  val black: Black
  val blue: Blue
  val cyan: Cyan
  val green: Green
  val magenta: Magenta
  val red: Red
  val white: White
  val yellow: Yellow

  val bold: Bold
  val underline: Underline

  val default: Default

  val reset: Reset
}

trait ImplicitColor {
  implicit def stringToFont(txt: String)(implicit default: FontParams): Font[UnPainted] = Font[UnPainted](txt)(default)
  implicit def fontToString[A <: Paint](fnt: Font[A]): String = fnt.colorText
  implicit def colorToFontParams(color: Color)(implicit default: FontParams): FontParams = FontParams(color, default.tone, default.bgColor, default.decors, default.reset, default.enable)
}

