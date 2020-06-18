package hancock.julie.dontgethangry.old.presenters

import android.content.Context
import android.content.Intent
import hancock.julie.dontgethangry.old.interfaces.ClickableLayoutListener
import hancock.julie.dontgethangry.old.interfaces.Presentation
import hancock.julie.dontgethangry.old.models.Restaurant
import hancock.julie.dontgethangry.old.models.Singleton
import hancock.julie.dontgethangry.old.views.PickingActivity

//TODO: moveToNext
class PickingPresenter(
    private val allRestaurants: List<Restaurant> = mutableListOf()
) : Presentation, ClickableLayoutListener {

    //TODO: cleanup undoing
    private var lastRest: Restaurant? = null
    private var saidYesToLastRest : Boolean = false
    private var index = 0

    private var curRestDisplayed: Restaurant? = null
    internal var bottomIsVisible = false


    override fun startActivity(comingFrom: Context) {
        comingFrom.startActivity(Intent(comingFrom, PickingActivity::class.java))
    }

    override fun leftClicked(): Any {
        Singleton.addPicked(getRestToDisplay()!!)
        moveToNext(true)
        return ""
    }

    override fun rightClicked(): Any {
        Singleton.addRejected(getRestToDisplay()!!)
        moveToNext(false)
        return ""
    }

    override fun bottomClicked(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun undoClicked(): Any {
        index--
        if(saidYesToLastRest)
            Singleton.removePicked(getRestToDisplay())
        else
            Singleton.removeRejected(getRestToDisplay())
        lastRest = null
        return ""
    }

    private fun moveToNext(wasAccepted: Boolean) {
        lastRest = getRestToDisplay()
        saidYesToLastRest = wasAccepted
        index++
    }

    fun getRestToDisplay(): Restaurant? {
        return if(index >= allRestaurants.size) null// TODO("PickingPresenter:: yikes. you're index is out of range")
        else allRestaurants[index]
    }

    fun shouldShowUndo() : Boolean {
        return when {
            index <= 0 -> false //don't show on first or before
            index >= allRestaurants.size -> false
            lastRest == null -> false
            else -> true
        }
    }

    fun negateBottomViewVisibility() {
        bottomIsVisible = !bottomIsVisible
    }
}
