package com.github.sassunt.scalor

import com.github.sassunt.scalor.Colors._
import com.github.sassunt.scalor.Tones._

import scala.Console
import scala.reflect.ClassManifest

sealed trait Paint
trait Painted   extends Paint
trait Unpainted extends Paint

object Font {
  def apply(txt: String) = new Font[Unpainted](txt)
}

case class Font[A <: Paint] private[scalor] (
  text:       String,
  color:      Color       = default,
  tone:       Tone        = normal,
  background: Background  = default,
  decors:     List[Decor] = List(default)
) {

  override def toString() = colorText

  val colorText = (tone match {
    case `normal` => color
    case `bright` => color.bright
    case `dark`   => color.dark
  }) + background.background + decors.foldLeft(""){ _ + _ } + text + reset

  def :#(color: Color) = this.copy[Painted](color = color)

  def :#[C <: Color](implicit m: ClassManifest[C]) = {
    val cls = m.erasure.newInstance().asInstanceOf[C]
    this.copy[Painted](color = cls)
  }

  def :~(color: Background) = this.copy(background = color)

  def :~[B <: Background](implicit m: ClassManifest[B]) = {
    val cls = m.erasure.newInstance().asInstanceOf[B]
    this.copy(background = cls)
  }

  def :@(tone: Tone)(implicit tn: A =:= Painted) = this.copy(tone = tone)

  def :@[T <: Tone](implicit tn: A =:= Painted, m: ClassManifest[T]) = {
    val cls = m.erasure.newInstance().asInstanceOf[T]
    this.copy(tone = cls)
  }

  def :@(decor: Decor) = this.copy(decors= decor :: decors)

  def :@[D <: Decor](implicit m: ClassManifest[D]) = {
    val cls = m.erasure.newInstance().asInstanceOf[D]
    this.copy(decors = cls :: this.decors)
  }

}

object Painter {
  private val colorReg = """#\{([^\{]*)\}""".r
}

case class Painter(text: String) {

  def paint(colors: Color*): String = {

    @scala.annotation.tailrec
    def colorPaint(txt: String, clrs: List[Color]):String = {
      clrs match {
        case c :: cs => {
          val t = Painter.colorReg.findFirstMatchIn(txt).map {x =>
            Painter.colorReg.replaceFirstIn(txt, new Font[Painted](x.group(1), c).colorText)
          }.getOrElse(txt)
          colorPaint(t, cs)
        }
        case _ => txt
      }

    }

    colorPaint(text, colors.toList)
  }

}

