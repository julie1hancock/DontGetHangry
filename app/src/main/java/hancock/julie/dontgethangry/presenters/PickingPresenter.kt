package hancock.julie.dontgethangry.presenters

import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton

public class PickingPresenter(
    private val allRestaurants: List<Restaurant>
) {

    var index = 0

    fun leftClicked() {
        Singleton.addPicked(getRestToDisplay()!!)
        index++
    }

    fun rightClicked() {
        Singleton.addRejected(getRestToDisplay()!!)
        index++
    }

    fun bottomClicked() {}

    fun getRestToDisplay(): Restaurant? {
        return if(index >= allRestaurants.size) null
        else allRestaurants[index]
    }
}
