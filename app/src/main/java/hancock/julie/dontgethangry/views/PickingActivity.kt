package hancock.julie.dontgethangry.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.presenters.PickingPresenter
import kotlinx.android.synthetic.main.activity_picking.*
import java.util.*
import kotlin.concurrent.schedule

class PickingActivity : AppCompatActivity() {

    lateinit var presenter: PickingPresenter
    var toDisplay: Restaurant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking)
        setSupportActionBar(toolbar)
        setupListening()
        presenter = PickingPresenter(Singleton.allRestaurants)
        updateView()
    }

    private fun setupListening() {
        left.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            presenter.leftClicked()
            flash(true)
            updateView()
            false
        }
        right.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            presenter.rightClicked()
            flash(false)
            updateView()
            false
        }
        bottom.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            presenter.bottomClicked()
            updateBottom()
            false
        }

    }

    private fun flash(isGreen: Boolean) {
        val AIsVisible = clickableLayout.isVisible
        val BIsVisible = middleView.isVisible
        val CIsVisible = milesLeft.isVisible
        val DIsVisible = bottomLayout.isVisible
        val EIsVisible = checkXLayoutGuy.isVisible
        val FIsVisible = infoCardView.isVisible

        clickableLayout.setVisibleOrGone(false)
        middleView.setVisibleOrGone(false)
        milesLeft.setVisibleOrGone(false)
        bottomLayout.setVisibleOrGone(false)
        checkXLayoutGuy.setVisibleOrGone(false)
        infoCardView.setVisibleOrGone(false)

        if(isGreen)
            colorLayout.setBackgroundColor(resources.getColor(R.color.mutedGreen))
        else
            colorLayout.setBackgroundColor(resources.getColor(R.color.mutedRed))
        colorLayout.setVisibleOrGone(true)

        Run.after(350) {
            colorLayout.setVisibleOrGone(false)
            clickableLayout.setVisibleOrGone(AIsVisible)
            middleView.setVisibleOrGone(BIsVisible)
            milesLeft.setVisibleOrGone(CIsVisible)
            bottomLayout.setVisibleOrGone(DIsVisible)
            checkXLayoutGuy.setVisibleOrGone(EIsVisible)
            infoCardView.setVisibleOrGone(FIsVisible)
        }
    }


    @SuppressLint("SetTextI18n")
    private fun updateView() {
        toDisplay = presenter.getRestToDisplay()
        if(toDisplay == null) {
            showEndScreen()
            return
        }

        restIcon.setImageResource(toDisplay?.image!!)
        milesLeft.text = "${toDisplay?.milesAway ?: "!!"} miles away"
        restName.text = toDisplay?.name ?: "!!"

        bottomTypeAndPrice.text = "${toDisplay?.type ?: "!!"} ${toDisplay?.price ?: "!!"}"
        bottomAddress.text = "Address: ${toDisplay?.address ?: "!!"}"
        bottomMiles.text = "${toDisplay?.milesAway ?: "!!"} miles away"
        bottomHours.text = "Hours: ${toDisplay?.hours ?: "!!"}"
        bottomWebsite.text = toDisplay?.website ?: "!!"

    }

    @SuppressLint("SetTextI18n")
    private fun showEndScreen() {
        startActivity(Intent(this, EndActivity::class.java))
        finish()
    }

    var bottomIsVisible = false
    private fun updateBottom() {
        bottomIsVisible = !bottomIsVisible
        if(bottomIsVisible){
            infoCardView.visibility = View.GONE
            bottomLayout.visibility = View.VISIBLE
            middleView.setPadding(0,0,0,450)
            milesLeft.visibility = View.GONE
        }
        else{
            infoCardView.visibility = View.VISIBLE

            bottomLayout.visibility = View.GONE
            middleView.setPadding(0,0,0,0)

            milesLeft.visibility = View.VISIBLE
        }

    }

}

private fun View.setVisibleOrGone(b: Boolean) {
    this.visibility = if(b) View.VISIBLE
    else View.GONE
}


class Run {
    companion object {
        fun after(delay: Long, process: () -> Unit) {
            Handler().postDelayed({
                process()
            }, delay)
        }
    }
}