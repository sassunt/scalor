package com.github.sassunt.scalor.ansi

import scala.Console

import com.github.sassunt.scalor._

object Colors extends com.github.sassunt.scalor.Colors {

  case object black extends Black {
    val fgPlain = Console.BLACK
    val fgBright = "\033[1;30m"
    val fgDark = "\033[2;30m"

    val bgPlain = Console.BLACK_B
  }

  case object blue extends Blue {
    val fgPlain = Console.BLUE
    val bgPlain = Console.BLUE_B
    val fgBright = "\033[1;34m"
    val fgDark = "\033[2;34m"
  }

  case object cyan extends Cyan {
    val fgPlain = Console.CYAN
    val bgPlain = Console.CYAN_B
    val fgBright = "\033[1;36m"
    val fgDark = "\033[2;36m"
  }

  case object green extends Green {
    val fgPlain = Console.GREEN
    val bgPlain = Console.GREEN_B
    val fgBright = "\033[1;32m"
    val fgDark = "\033[2;32m"
  }

  case object magenta extends Magenta {
    val fgPlain = Console.MAGENTA
    val bgPlain = Console.MAGENTA_B
    val fgBright = "\033[1;35m"
    val fgDark = "\033[2;35m"
  }

  case object red extends Red {
    val fgPlain = Console.RED
    val bgPlain = Console.RED_B
    val fgBright = "\033[1;31m"
    val fgDark = "\033[2;31m"
  }

  case object white extends White {
    val fgPlain = Console.WHITE
    val bgPlain = Console.WHITE_B
    val fgBright = "\033[1;37m"
    val fgDark = "\033[2;37m"
  }

  case object yellow extends Yellow {
    val fgPlain = Console.YELLOW
    val bgPlain = Console.YELLOW_B
    val fgBright = "\033[1;33m"
    val fgDark = "\033[2;33m"
  }

  case object bold extends Bold {
    val decor = Console.BOLD
  }

  case object underline extends Underline {
    val decor = Console.UNDERLINED
  }

  case object default extends Default {
    val fgPlain = ""
    val bgPlain = ""
    val fgBright = ""
    val fgDark = ""

    val decor = ""
  }

  case object reset extends Reset {
    val reset = Console.RESET
  }
}

trait ImplicitAnsiColor {
  implicit object AnsiDefaultFontParams extends FontParams(Colors.default, Tones.plain, Colors.default, List(Colors.default), Colors.reset, true)
}
