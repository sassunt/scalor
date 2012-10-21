package com.github.sassunt.scalor

import scala.Console

sealed trait Paint
trait Painted extends Paint
trait UnPainted extends Paint

case class FontParams(color: Color,
                      tone: Tone,
                      bgColor: BgColor,
                      decors: List[Decor],
                      reset: Reset,
                      enable: Boolean) {
}

case class Font[A <: Paint] private[scalor] (
  text: String)(implicit private[scalor] var params: FontParams) { self =>

  override def toString = colorText

  def colorText = if (self.params.enable)
    self.params.color(self.params.tone) + self.params.bgColor.bgPlain + self.params.decors.foldLeft("") { _ + _.decor } + text + self.params.reset.reset
  else
    text

  def :#(color: Color): Font[Painted] = self.copy[Painted]()(self.params.copy(color = color))

  def :~(color: BgColor) = this.copy[A]()(self.params.copy(bgColor = color))

  def :@(tone: Tone)(implicit tn: A =:= Painted): Font[Painted] = self.copy[Painted]()(self.params.copy(tone = tone))

  def :@(decor: Decor) = self.copy[Painted]()(self.params.copy(decors = decor :: self.params.decors))
}

object Painter {
  private val colorReg = """#\{([^\{]*)\}""".r
}

case class Painter(text: String) {

  def paint(params: FontParams*): String = {

    @scala.annotation.tailrec
    def colorPaint(txt: String, params: List[FontParams]): String = {
      params match {
        case p :: ps => {
          val t = Painter.colorReg.findFirstMatchIn(txt).map { x =>
            Painter.colorReg.replaceFirstIn(txt, new Font[Painted](x.group(1))(p).colorText)
          }.getOrElse(txt)
          colorPaint(t, ps)
        }
        case _ => txt
      }

    }

    colorPaint(text, params.toList)
  }

}
