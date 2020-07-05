package hancock.julie.dontgethangry.end

import android.content.res.Resources
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton

interface EndPresentation {
    fun hangerAvoided(): Boolean
    fun getOverlapping(): List<Restaurant>
    fun getTitle(resources: Resources): String
    fun getSubtitle(resources: Resources): String
}

class EndPresenter : EndPresentation {

    private var overlappingRests = mutableListOf<Restaurant>()

    override fun getTitle(resources: Resources) =
        if(hangerAvoided()) resources.getString(R.string.hanger_avoided)
        else resources.getString(R.string.hanger_not_avoided)

    override fun getSubtitle(resources: Resources) =
        if(hangerAvoided() || !Singleton.diningAlone) resources.getString(R.string.nav_instructions)
        else resources.getString(R.string.oh_no)

    override fun getOverlapping(): List<Restaurant> {
        return overlappingRests
    }

    override fun hangerAvoided(): Boolean {
        if(overlappingRests.isEmpty()) setOverlapping()

        return when {
            Singleton.youPicked.isEmpty() -> false
            Singleton.diningAlone -> true
            Singleton.theyPicked.isEmpty() -> false
            else -> overlappingRests.isNotEmpty()
        }
    }

    private fun setOverlapping(): Boolean {
        Singleton.theyPicked.forEach {
            if(Singleton.youPicked.contains(it) && !overlappingRests.contains(it)) {
                overlappingRests.add(it)
            }
        }
        return overlappingRests.isNotEmpty()
    }

}