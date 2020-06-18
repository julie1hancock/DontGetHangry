package hancock.julie.dontgethangry.old.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.old.helpers.toastListener
import hancock.julie.dontgethangry.old.presenters.InstructionPresentation
import hancock.julie.dontgethangry.old.presenters.PickingPresenter
import kotlinx.android.synthetic.main.activity_instruction_old.*

class InstructionActivity : AppCompatActivity() {

    lateinit var presenter : InstructionPresentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction_old)

        presenter = InstructionPresentation() //TODO : inject

        left.toastListener(presenter.leftClicked(), this)
        right.toastListener(presenter.rightClicked(), this)
        bottom.toastListener(presenter.bottomClicked(), this)
        undoCardView.toastListener(presenter.undoClicked(), this)

        instructionArrow.setOnClickListener{
            PickingPresenter().startActivity(this)
        }
    }
}

