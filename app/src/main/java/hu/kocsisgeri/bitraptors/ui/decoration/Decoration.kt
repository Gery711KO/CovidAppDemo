package hu.kocsisgeri.bitraptors.ui.decoration

data class Decoration(
    val topSpacing: Int = 0,
    val bottomSpacing: Int = 0,
    val leftSpacing: Int = 0,
    val rightSpacing: Int = 0,
) {
    fun hasOffset() =
        topSpacing != 0 || bottomSpacing != 0 || leftSpacing != 0 || rightSpacing != 0

    companion object {
        val NONE = Decoration(-1, -1, -1, -1)
        val NORMAL = Decoration(0, 0, 0, 0)
    }
}


