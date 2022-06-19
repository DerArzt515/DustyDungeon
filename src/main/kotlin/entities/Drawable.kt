package entities

import java.awt.Dimension
import java.awt.Graphics2D

interface Drawable {
    fun draw(graphics: Graphics2D, screenSize: Dimension)
}