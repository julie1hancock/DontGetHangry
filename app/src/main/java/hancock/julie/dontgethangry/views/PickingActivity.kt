package hancock.julie.dontgethangry.views

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.presenters.PickingPresenter
import kotlinx.android.synthetic.main.activity_picking.*
import kotlinx.android.synthetic.main.content_picking.*

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
            updateView()
            false
        }
        right.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            presenter.rightClicked()
            updateView()
            false
        }
        bottom.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            presenter.bottomClicked()
            updateBottom()
            false
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

//            R.drawable.chickfilalogo)

//        restIcon.setImageResource()
//        val bitmap = BitmapFactory.decodeFile("~/Downloads/chickfilalogo.jpg")
//        restIcon.setImageBitmap(bitmap)
        milesLeft.text = "${toDisplay?.milesAway ?: "!!"} miles"
        restName.text = toDisplay?.name ?: "!!"

        bottomTypeAndPrice.text = "${toDisplay?.type ?: "!!"} ${toDisplay?.price ?: "!!"}"
        bottomAddress.text = "Address: ${toDisplay?.address ?: "!!"}"
        bottomMiles.text = "${toDisplay?.milesAway ?: "!!"} miles away"
        bottomHours.text = "Hours: ${toDisplay?.hours ?: "!!"}"
        bottomWebsite.text = "Website: ${toDisplay?.website ?: "!!"}"
    }

    @SuppressLint("SetTextI18n")
    private fun showEndScreen() {
        startActivity(Intent(this, EndActivity::class.java))
        finish()
    }

    var bottomIsVisible = false
    private fun updateBottom() {
        bottomIsVisible = !bottomIsVisible
        if(bottomIsVisible)
            bottomLayout.visibility = View.VISIBLE
        else
            bottomLayout.visibility = View.GONE

    }

}
