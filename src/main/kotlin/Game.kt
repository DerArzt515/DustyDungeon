import io.*
import kotlinx.coroutines.*
import kotlinx.coroutines.swing.Swing
import java.awt.*
import javax.swing.JFrame
import javax.swing.WindowConstants

class Game(val screenSize: Dimension) : Canvas() {
    var scene: Scene? = null
    val input = Input()
    private var gameLoop: Job? = null

    init {
        size = screenSize
        addKeyListener(input)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun run() {
        if (gameLoop != null) return

        gameLoop = GlobalScope.launch {
            var lastIterationTime = System.nanoTime()

            while (isActive) {
                val scene = scene ?: continue
                val now = System.nanoTime()
                val timePassed = now - lastIterationTime
                lastIterationTime = now
                scene.update(timePassed)
                withContext(Dispatchers.Swing) {
                    scene.draw(bufferStrategy.drawGraphics as Graphics2D)
                    bufferStrategy.show()
                }
            }
        }
    }

    fun pause() = runBlocking {
        gameLoop?.cancel()
        gameLoop?.join()
        gameLoop = null
    }
}

object GameFactory {
    fun create(
        screenSize: Dimension,
        windowTitle: String
    ): Game {
        val game = Game(screenSize)
        JFrame().apply {
            title = windowTitle
            isVisible = true
            layout = BorderLayout()
            add(game)
            pack()

            defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            setLocationRelativeTo(null)
        }
        val numBuffers = 2
        game.createBufferStrategy(numBuffers)
        game.requestFocus()
        return game
    }
}


fun main() {
    val game = GameFactory.create(
        screenSize = Dimension(660, 660),
        windowTitle = "Dat Game"
    )

    val settings = Settings.build()
    game.scene = GameScene(game, settings)
    game.run()
}