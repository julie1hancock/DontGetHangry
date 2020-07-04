package hancock.julie.dontgethangry.end

import android.content.res.Resources
import androidx.fragment.app.Fragment
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.end.no.HangryAloneFragment
import hancock.julie.dontgethangry.end.no.HangryTogetherFragment
import hancock.julie.dontgethangry.end.no.NotHangryAloneFragment
import hancock.julie.dontgethangry.end.no.NotHangryTogetherFragment
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton

interface EndPresentation {
    fun hangerAvoided(): Boolean
    fun getOverlapping(): List<Restaurant>
    fun getSubText(resources: Resources): String
    fun getFragment(): Fragment
    fun cantNavigate(): Boolean
}

class EndPresenter : EndPresentation {

    private var overlappingRests = mutableListOf<Restaurant>()

    override fun cantNavigate() = Singleton.diningAlone && Singleton.youPicked.isEmpty()

    override fun getFragment(): Fragment {
        return if(hangerAvoided()) {
            if (Singleton.diningAlone) NotHangryAloneFragment()
            else NotHangryTogetherFragment()
        }
        else if (Singleton.diningAlone) HangryAloneFragment()
        else HangryTogetherFragment()
    }

    override fun getSubText(resources: Resources) =
        if(hangerAvoided()) resources.getString(R.string.hanger_avoided)
        else resources.getString(R.string.hanger_not_avoided)

    override fun getOverlapping(): List<Restaurant> {
//        setOverlapping()
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