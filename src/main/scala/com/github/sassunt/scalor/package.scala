package com.github.sassunt

package object scalor extends ImplicitColor {

  lazy val enableScalor = !"false".equals(sys.props("scalor.enable"))
}
