import java.awt.Font

data class Settings(val primaryFont: Font, val secondaryFont: Font) {
    companion object {
        fun build(): Settings {
            return Settings(
                primaryFont = Font("Default", Font.BOLD, 30),
                secondaryFont = Font("Default", Font.PLAIN, 20)
            )
        }
    }
}
