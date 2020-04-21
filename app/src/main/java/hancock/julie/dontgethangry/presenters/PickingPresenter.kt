package hancock.julie.dontgethangry.presenters

import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton

class PickingPresenter(
    private val allRestaurants: List<Restaurant>
) {

    var lastRest: Restaurant? = null
    var saidYesToLastRest : Boolean = false

    var index = 0

    fun leftClicked() {
        Singleton.addPicked(getRestToDisplay()!!)
        cleanup(true)
    }

    private fun cleanup(b: Boolean) {
        lastRest = getRestToDisplay()
        saidYesToLastRest = b
        index++
    }

    fun rightClicked() {
        Singleton.addRejected(getRestToDisplay()!!)
        cleanup(false)
    }

    fun getRestToDisplay(): Restaurant? {
        return if(index >= allRestaurants.size) null
        else allRestaurants[index]
    }

    fun undoClicked() {
        index--
        if(saidYesToLastRest)
            Singleton.removePicked(getRestToDisplay())
        else
            Singleton.removeRejected(getRestToDisplay())
        lastRest = null
    }

    fun showUndo() : Boolean {
        return when {
            index <= 0 -> false //don't show on first or before
            index >= allRestaurants.size -> false
            lastRest == null -> false
            else -> true
        }
    }
}
