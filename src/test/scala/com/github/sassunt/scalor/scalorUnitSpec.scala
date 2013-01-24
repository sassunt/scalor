package com.github.sassunt.scalor.specs2

import org.specs2.mutable._

class ScalorUntSpec extends Specification {

  import com.github.sassunt.scalor._
  import Colors._, Tones._

  ":# method" should {
    "return string with ANSI color for Color" in {
      ("BLUE" :# blue).toString mustEqual "\033[34mBLUE\033[0m"
      ("BLUE".:#[Blue]).toString mustEqual "\033[34mBLUE\033[0m"
    }

    "return Font for Color" in {
      val font1 = "YELLOW" :# yellow
      font1.text mustEqual "YELLOW"
      font1.color mustEqual yellow
      font1.tone mustEqual normal
      font1.background mustEqual default
      font1.decors mustEqual List(default)

      val font2 = "YELLOW".:#[Yellow]
      font2.text mustEqual "YELLOW"
      font2.color mustEqual yellow
      font2.tone mustEqual normal
      font2.background mustEqual default
      font2.decors mustEqual List(default)
    }
  }

  ":~ method" should {
    "return string with ANSI color for Background" in {
      ("GREEN" :~ green).toString mustEqual "\033[42mGREEN\033[0m"
      ("GREEN".:~[Green]).toString mustEqual "\033[42mGREEN\033[0m"
    }

    "return Font for Background" in {
      val font1 = "YELLOW" :~ yellow
      font1.text mustEqual "YELLOW"
      font1.color mustEqual default
      font1.tone mustEqual normal
      font1.background mustEqual yellow
      font1.decors mustEqual List(default)

      val font2 = "YELLOW".:~[Yellow]
      font2.text mustEqual "YELLOW"
      font2.color mustEqual default
      font2.tone mustEqual normal
      font2.background mustEqual yellow
      font2.decors mustEqual List(default)
    }
  }

  ":@ method" should {
    "return string with ANSI color for Decor" in {
      ("BOLD" :@ bold).toString mustEqual "\033[1mBOLD\033[0m"
      ("BOLD".:@[Bold]).toString mustEqual "\033[1mBOLD\033[0m"
    }

    "return Font for Decor" in {
      val font1= "UNDERLINE" :@ underline
      font1.text mustEqual "UNDERLINE"
      font1.color mustEqual default
      font1.tone mustEqual normal
      font1.background mustEqual default
      font1.decors mustEqual List(underline, default)

      val font2 = "UNDERLINE".:@[Underline]
      font2.text mustEqual "UNDERLINE"
      font2.color mustEqual default
      font2.tone mustEqual normal
      font2.background mustEqual default
      font2.decors mustEqual List(underline, default)
    }
  }
}
