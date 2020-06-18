package hancock.julie.dontgethangry.presenters

import android.content.Context
import android.content.Intent
import hancock.julie.dontgethangry.interfaces.ClickableLayoutListener
import hancock.julie.dontgethangry.interfaces.Presentation
import hancock.julie.dontgethangry.views.InstructionActivity

class InstructionPresentation : Presentation, ClickableLayoutListener {
    override fun undoClicked(): String = "That will undo your last choice"

    override fun leftClicked(): String = "That says you DID pick the current restaurant"

    override fun rightClicked(): String = "That says you did NOT pick the current restaurant"

    override fun bottomClicked(): String = "That will show more info on the current restaurant"

    override fun startActivity(comingFrom: Context) {
        comingFrom.startActivity(Intent(comingFrom, InstructionActivity::class.java))
    }
}