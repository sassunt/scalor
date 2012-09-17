package com.github.sassunt.scalor

import scala.Console

sealed trait Color {
  def apply(txt: String) = Font(txt) :# this
  val bright: String
  val dark  : String
}

sealed trait Background {
  val background: String
}

sealed trait Decor

final object Colors {
  private[Colors] case class C_Black()    extends Color with Background {
    override def toString() = Console.BLACK
    val background = Console.BLACK_B
    val bright = "\033[1;30m"
    val dark   = "\033[2;30m"
  }

  private[Colors] case class C_Blue()     extends Color with Background {
    override def toString() = Console.BLUE
    val background = Console.BLUE_B
    val bright = "\033[1;34m"
    val dark   = "\033[2;34m"
  }

  private[Colors] case class C_Cyan()     extends Color with Background {
    override def toString() = Console.CYAN
    val background = Console.CYAN_B
    val bright = "\033[1;36m"
    val dark   = "\033[2;36m"
  }

  private[Colors] case class C_Green()    extends Color with Background{
    override def toString() = Console.GREEN
    val background = Console.GREEN_B
    val bright = "\033[1;32m"
    val dark   = "\033[2;32m"
  }
  private[Colors] case class C_Magenta()  extends Color with Background {
    override def toString() = Console.MAGENTA
    val background = Console.MAGENTA_B
    val bright = "\033[1;35m"
    val dark   = "\033[2;35m"
  }

  private[Colors] case class C_Red()      extends Color with Background {
    override def toString() = Console.RED
    val background = Console.RED_B
    val bright = "\033[1;31m"
    val dark   = "\033[2;31m"
  }

  private[Colors] case class C_White()    extends Color with Background {
    override def toString() = Console.WHITE
    val background = Console.WHITE_B
    val bright = "\033[1;37m"
    val dark   = "\033[2;37m"
  }

  private[Colors] case class C_Yellow()   extends Color with Background {
    override def toString() = Console.YELLOW
    val background = Console.YELLOW_B
    val bright = "\033[1;33m"
    val dark   = "\033[2;33m"
  }

  private[Colors] case class C_Default()  extends Color with Background with Decor{
    override def toString() = ""
    val background  = ""
    val bright      = ""
    val dark        = ""
    val decor       = ""
  }

  private[Colors] case class C_Bold() extends Decor {
    override def toString() = Console.BOLD
  }

  private[Colors] case class C_Underline() extends Decor {
    override def toString() = Console.UNDERLINED
  }

  private[Colors] case class C_Reset() {
    override def toString() = Console.RESET
  }

  type Black     = C_Black
  type Blue      = C_Blue
  type Cyan      = C_Cyan
  type Green     = C_Green
  type Magenta   = C_Magenta
  type Red       = C_Red
  type White     = C_White
  type Yellow    = C_Yellow
  type Reset     = C_Reset
  type Default   = C_Default
  type Underline = C_Underline
  type Bold      = C_Bold

  val black     = C_Black()
  val blue      = C_Blue()
  val cyan      = C_Cyan()
  val green     = C_Green()
  val magenta   = C_Magenta()
  val red       = C_Red()
  val white     = C_White()
  val yellow    = C_Yellow()
  val reset     = C_Reset()
  val default   = C_Default()
  val underline = C_Underline()
  val bold      = C_Bold()

}

object Tones {
  sealed trait Tone
  object normal extends Tone
  object dark   extends Tone
  object bright extends Tone

  type Normal = normal.type
  type Dark   = dark.type
  type Bright = bright.type
}

trait ImplicitColor {
  implicit def stringToFont(txt: String) = Font[UnPainted](txt)
  implicit def fontToString[A <: Paint](fnt: Font[A]) = fnt.toString()
  implicit def stringToPaint(txt: String) = Painter(txt)
}

