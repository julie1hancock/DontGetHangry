package hancock.julie.dontgethangry.presenters

import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton

//TODO: cleanup
class EndPresenter {

    var overlappingRests = mutableListOf<Restaurant>()

    init {
        println()
        var youPicked = Singleton.youPicked
        var theyPicked = Singleton.theyPicked

        theyPicked.forEach {
            if(youPicked.contains(it)) {
                overlappingRests.add(it)
            }
        }

    }

    fun isWinning(): Boolean{
        return overlappingRests.isNotEmpty()
    }
}