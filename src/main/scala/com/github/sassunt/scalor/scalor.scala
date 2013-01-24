package com.github.sassunt.scalor

import com.github.sassunt.scalor.Colors._
import com.github.sassunt.scalor.Tones._

import scala.Console
import scala.reflect.ClassTag

sealed trait Paint
trait Painted   extends Paint
trait UnPainted extends Paint

object Font {
  def apply(txt: String) = new Font[UnPainted](txt)
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

  def :#[C <: Color](implicit classTag: ClassTag[C]) = {
    val cls = classTag.runtimeClass.newInstance.asInstanceOf[C]
    this.copy[Painted](color = cls)
  }

  def :~(color: Background) = this.copy[A](background = color)

  def :~[B <: Background](implicit classTag: ClassTag[B]) = {
    val cls = classTag.runtimeClass.newInstance().asInstanceOf[B]
    this.copy[A](background = cls)
  }

  //def :@(tone: Tone)(implicit tn: A =:= Painted) = this.copy[A](tone = tone)

  def :@[T <: Tone](implicit tn: A =:= Painted, classTag: ClassTag[T]) = {
    val cls = classTag.runtimeClass.newInstance().asInstanceOf[T]
    this.copy[A](tone = cls)
  }

  //def :@(decor: Decor) = this.copy[A](decors= decor :: decors)

  def :@[D <: Decor](implicit classTag: ClassTag[D]) = {
    val cls = classTag.runtimeClass.newInstance().asInstanceOf[D]
    this.copy[A](decors = cls :: this.decors)
  }

  def :@(magnet: FontMagnet[A]):magnet.Result = magnet.decorate(this)

}
trait FontMagnet[P <: Paint] {
  type Result
  def decorate(font: Font[P]): Result
}

trait ImplicitFontMagnet {
  implicit def fromTone[P <: Painted](tone: Tone) = new FontMagnet[P] {
    type Result = Font[P]
    def decorate(font: Font[P]): Result = {
      font.copy[P](tone = tone)
    }
  }
  implicit def fromDecor[P <: Paint](decor: Decor) = new FontMagnet[P]{
    type Result = Font[P]
    def decorate(font: Font[P]): Result = {
      font.copy[P](decors = decor :: font.decors)
    }
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

