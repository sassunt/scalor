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
  case class Black private[Colors]()    extends Color with Background {
    override def toString() = Console.BLACK
    val background = Console.BLACK_B
    val bright = "\033[1;30m"
    val dark   = "\033[2;30m"
  }

  case class Blue private[Colors]()     extends Color with Background {
    override def toString() = Console.BLUE
    val background = Console.BLUE_B
    val bright = "\033[1;34m"
    val dark   = "\033[2;34m"
  }

  case class Cyan private[Colors]()     extends Color with Background {
    override def toString() = Console.CYAN
    val background = Console.CYAN_B
    val bright = "\033[1;36m"
    val dark   = "\033[2;36m"
  }

  case class Green private[Colors]()    extends Color with Background{
    override def toString() = Console.GREEN
    val background = Console.GREEN_B
    val bright = "\033[1;32m"
    val dark   = "\033[2;32m"
  }

  case class Magenta private[Colors]()  extends Color with Background {
    override def toString() = Console.MAGENTA
    val background = Console.MAGENTA_B
    val bright = "\033[1;35m"
    val dark   = "\033[2;35m"
  }

  case class Red private[Colors]()      extends Color with Background {
    override def toString() = Console.RED
    val background = Console.RED_B
    val bright = "\033[1;31m"
    val dark   = "\033[2;31m"
  }

  case class White private[Colors]()    extends Color with Background {
    override def toString() = Console.WHITE
    val background = Console.WHITE_B
    val bright = "\033[1;37m"
    val dark   = "\033[2;37m"
  }

  case class Yellow private[Colors]()   extends Color with Background {
    override def toString() = Console.YELLOW
    val background = Console.YELLOW_B
    val bright = "\033[1;33m"
    val dark   = "\033[2;33m"
  }

  case class Default private[Colors]()  extends Color with Background with Decor {
    override def toString() = ""
    val background  = ""
    val bright      = ""
    val dark        = ""
  }

  case class Bold private[Colors]()      extends Decor {
    override def toString() = Console.BOLD
  }

  case class Underline private[Colors]() extends Decor {
    override def toString() = Console.UNDERLINED
  }

  case class Reset private[Colors]() {
    override def toString() = Console.RESET
  }

  val black     = Black()
  val blue      = Blue()
  val cyan      = Cyan()
  val green     = Green()
  val magenta   = Magenta()
  val red       = Red()
  val white     = White()
  val yellow    = Yellow()
  val reset     = Reset()
  val default   = Default()
  val underline = Underline()
  val bold      = Bold()

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

