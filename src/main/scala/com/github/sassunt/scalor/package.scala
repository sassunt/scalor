package com.github.sassunt

package object scalor extends ImplicitColor {

  lazy val enableScalor = "true".equals(sys.props("scalor.enable"))
}
