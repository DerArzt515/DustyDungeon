package io

import Game
import Settings
import java.awt.Color
import java.awt.Graphics2D
import java.util.concurrent.TimeUnit

class GameScene(game: Game, val settings: Settings) : Scene(game) {
    private var lastKeyPressed = ""

    override fun update(timePassed: Long, timeUnits: TimeUnit) {
        game.input.consumeEvents()
            .filterIsInstance<Input.Event.KeyPressed>()
            .forEach {
                lastKeyPressed = it.data.keyChar.toString()
            }
    }

    override fun draw(graphics: Graphics2D) {
        graphics.apply {
            color = Color.BLACK
            fillRect(0, 0, game.screenSize.width, game.screenSize.height)

            font = settings.primaryFont
            color = Color.white
            val name = "Dat Game Dough"
            drawString(
                name,
                game.screenSize.width / 2 - fontMetrics.stringWidth(name) / 2,
                game.screenSize.height / 2 - 50
            )

            font = settings.secondaryFont
            color = Color.gray
            val message = "Press Enter to continue"

            drawString(
                message,
                game.screenSize.width / 2 - fontMetrics.stringWidth(message) / 2,
                game.screenSize.height / 2 + 50
            )

            font = settings.secondaryFont
            color = Color.PINK
            val keyPressed = "Last Key pressed was $lastKeyPressed"

            drawString(
                keyPressed,
                game.screenSize.width / 2 - fontMetrics.stringWidth(message) / 2,
                game.screenSize.height / 2 + 100
            )
        }
    }
}