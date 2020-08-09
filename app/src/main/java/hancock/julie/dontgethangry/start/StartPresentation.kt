package hancock.julie.dontgethangry.start

interface StartPresentation {
    fun generateString(size: Int = 5): String
}

class StartPresenter : StartPresentation {
    override fun generateString(size: Int): String {
        return "AQTFY"
    }
}