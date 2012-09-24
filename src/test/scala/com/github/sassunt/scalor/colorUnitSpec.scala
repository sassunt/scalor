package com.github.sassunt.scalor.specs2

import org.specs2.mutable._

class ColorUnitSpec extends Specification {

  import com.github.sassunt.scalor._
  import Colors._, Tones._

  "Color" should {
    "normal ANSI color code" in {
      black.toString   mustEqual "\033[30m"
      blue.toString    mustEqual "\033[34m"
      cyan.toString    mustEqual "\033[36m"
      green.toString   mustEqual "\033[32m"
      magenta.toString mustEqual "\033[35m"
      red.toString     mustEqual "\033[31m"
      white.toString   mustEqual "\033[37m"
      yellow.toString  mustEqual "\033[33m"
      default.toString mustEqual ""
    }

    "bright ANSI color code" in {
      black.bright   mustEqual "\033[1;30m"
      blue.bright    mustEqual "\033[1;34m"
      cyan.bright    mustEqual "\033[1;36m"
      green.bright   mustEqual "\033[1;32m"
      magenta.bright mustEqual "\033[1;35m"
      red.bright     mustEqual "\033[1;31m"
      white.bright   mustEqual "\033[1;37m"
      yellow.bright  mustEqual "\033[1;33m"
      default.bright mustEqual ""
    }

    "dark ANSI color code" in {
      black.dark   mustEqual "\033[2;30m"
      blue.dark    mustEqual "\033[2;34m"
      cyan.dark    mustEqual "\033[2;36m"
      green.dark   mustEqual "\033[2;32m"
      magenta.dark mustEqual "\033[2;35m"
      red.dark     mustEqual "\033[2;31m"
      white.dark   mustEqual "\033[2;37m"
      yellow.dark  mustEqual "\033[2;33m"
      default.dark mustEqual ""
    }

    "background ANSI color code" in {
      black.background   mustEqual "\033[40m"
      blue.background    mustEqual "\033[44m"
      cyan.background    mustEqual "\033[46m"
      green.background   mustEqual "\033[42m"
      magenta.background mustEqual "\033[45m"
      red.background     mustEqual "\033[41m"
      white.background   mustEqual "\033[47m"
      yellow.background  mustEqual "\033[43m"
      default.background mustEqual ""
    }

    "other ANSI string code" in {
      bold.toString      mustEqual "\033[1m"
      underline.toString mustEqual "\033[4m"
      reset.toString     mustEqual "\033[0m"
    }
  }
}

