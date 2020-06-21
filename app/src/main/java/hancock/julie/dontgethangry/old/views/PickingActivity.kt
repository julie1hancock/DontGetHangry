package hancock.julie.dontgethangry.old.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.old.helpers.Run
import hancock.julie.dontgethangry.old.helpers.setColor
import hancock.julie.dontgethangry.old.helpers.setVisibleOrGone
import hancock.julie.dontgethangry.old.helpers.startExternal
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.old.presenters.PickingPresenter
import kotlinx.android.synthetic.main.activity_picking_old.*


class PickingActivity : AppCompatActivity() {

    private lateinit var presenter: PickingPresenter //TODO: cast up


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking_old)
        setSupportActionBar(toolbar)

        presenter = PickingPresenter(Singleton.allRestaurants) //TODO: cleanup

        setupListening()
        updateView()
    }

    private fun setupListening() {
        left.setOnClickListener{
            presenter.leftClicked()
            flash(true)
            updateView()
            false
        }
        right.setOnClickListener{
            presenter.rightClicked()
            flash(false)
            updateView()
            false
        }
        bottom.setOnClickListener{
            presenter.bottomClicked()
            updateBottom()
            false
        }

        undoCardView.setOnClickListener{
            presenter.undoClicked()
            flash(null)
            updateView()
            false
        }
        bottomWebsite.setOnClickListener{
            startExternal("https://${presenter.getRestToDisplay()?.website ?: "google.com"}/", this)
        }

    }

    private fun flash(isGreen: Boolean?) {
        clickableLayout.setVisibleOrGone(false)
        middleView.setVisibleOrGone(false)
        milesLeft.setVisibleOrGone(false)
        bottomLayout.setVisibleOrGone(false)
        checkXLayoutGuy.setVisibleOrGone(false)
        infoCardView.setVisibleOrGone(false)

        colorLayout.setColor(isGreen, resources)
        colorLayout.setVisibleOrGone(true)

        Run.after(250) {
            colorLayout.setVisibleOrGone(false)

            clickableLayout.setVisibleOrGone(true)
            middleView.setVisibleOrGone(true)
            checkXLayoutGuy.setVisibleOrGone(true)

            bottomLayout.setVisibleOrGone(presenter.bottomIsVisible)
            milesLeft.setVisibleOrGone(!presenter.bottomIsVisible)
            infoCardView.setVisibleOrGone(!presenter.bottomIsVisible)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateView() {
        undoCardView.setVisibleOrGone(presenter.shouldShowUndo())
        val toDisplay = presenter.getRestToDisplay()

        if(toDisplay == null) {
            showEndScreen()
            return
        }

        restIcon.setImageResource(toDisplay.getDisplayImage())
        milesLeft.text = toDisplay.getDisplayMilesAway()
        restName.text = toDisplay.getDisplayName()

        bottomTypeAndPrice.text = toDisplay.getDisplayTypeAndPrice()
        bottomAddress.text = toDisplay.getDisplayAddress()
        bottomMiles.text = toDisplay.getDisplayMilesAway()
        bottomHours.text = toDisplay.getDisplayHours()
        bottomWebsite.text = toDisplay.getDisplayWebsite()

    }

    private fun showEndScreen() {
        startActivity(Intent(this, EndActivity::class.java)) //TODO
        finish()
    }

    private fun updateBottom() {
        presenter.negateBottomViewVisibility()

        if(presenter.bottomIsVisible) {
            bottomLayout.setVisibleOrGone(true)
            infoCardView.setVisibleOrGone(false)
            middleView.setPadding(0,0,0,450)
            milesLeft.setVisibleOrGone(false)
        }
        else {
            bottomLayout.setVisibleOrGone(false)
            infoCardView.setVisibleOrGone(true)
            middleView.setPadding(0,0,0,0)
            milesLeft.setVisibleOrGone(true)
        }

    }

}



