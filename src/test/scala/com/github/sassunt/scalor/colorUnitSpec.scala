package com.github.sassunt.scalor.specs2

import org.specs2.mutable._

class ColorUnitSpec extends Specification {

  
  import com.github.sassunt.scalor.ansi._
  import Colors._
  
  "Color" should {
    "normal ANSI color code" in {
      black.fgPlain   mustEqual "\033[30m"
      blue.fgPlain    mustEqual "\033[34m"
      cyan.fgPlain    mustEqual "\033[36m"
      green.fgPlain   mustEqual "\033[32m"
      magenta.fgPlain mustEqual "\033[35m"
      red.fgPlain     mustEqual "\033[31m"
      white.fgPlain   mustEqual "\033[37m"
      yellow.fgPlain  mustEqual "\033[33m"
      default.fgPlain mustEqual ""
    }

    "bright ANSI color code" in {
      black.fgBright   mustEqual "\033[1;30m"
      blue.fgBright    mustEqual "\033[1;34m"
      cyan.fgBright    mustEqual "\033[1;36m"
      green.fgBright   mustEqual "\033[1;32m"
      magenta.fgBright mustEqual "\033[1;35m"
      red.fgBright     mustEqual "\033[1;31m"
      white.fgBright   mustEqual "\033[1;37m"
      yellow.fgBright  mustEqual "\033[1;33m"
      default.fgBright mustEqual ""
    }

    "dark ANSI color code" in {
      black.fgDark   mustEqual "\033[2;30m"
      blue.fgDark    mustEqual "\033[2;34m"
      cyan.fgDark    mustEqual "\033[2;36m"
      green.fgDark   mustEqual "\033[2;32m"
      magenta.fgDark mustEqual "\033[2;35m"
      red.fgDark     mustEqual "\033[2;31m"
      white.fgDark   mustEqual "\033[2;37m"
      yellow.fgDark  mustEqual "\033[2;33m"
      default.fgDark mustEqual ""
    }

    "background ANSI color code" in {
      black.bgPlain   mustEqual "\033[40m"
      blue.bgPlain    mustEqual "\033[44m"
      cyan.bgPlain    mustEqual "\033[46m"
      green.bgPlain   mustEqual "\033[42m"
      magenta.bgPlain mustEqual "\033[45m"
      red.bgPlain     mustEqual "\033[41m"
      white.bgPlain   mustEqual "\033[47m"
      yellow.bgPlain  mustEqual "\033[43m"
      default.bgPlain mustEqual ""
    }

    "other ANSI string code" in {
      bold.decor      mustEqual "\033[1m"
      underline.decor mustEqual "\033[4m"
      reset.reset     mustEqual "\033[0m"
    }
  }
}
