package hancock.julie.dontgethangry.start

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_epoxy.*
import kotlinx.android.synthetic.main.toolbar.view.*

class CreateDecisionActivity : AppCompatActivity() {

    lateinit var presenter: StartPresentation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)
        toolbar.toolbarTitle.text = getString(R.string.create_decision_group)
        presenter = StartPresenter()

        epoxyRv.setModels(
            listOf(
                createText(
                    text = getString(R.string.decision_code),
                    textType = TextType.Text4,
                    center = true
                ),
                createDecisionCodeRow(
                    edit = false,
                    string = presenter.generateString()
                ),
                createText(
                    text = getString(R.string.share_code),
                    textType = TextType.Subtext6,
                    center = true
                ),
                createLine(),
                createText(
                    text = getString(R.string.waiting_for_others),
                    textType = TextType.Text5,
                    center = true
                ),
//                createPersonRow(
//                    index = 0,
//                    name = "Emily"
//                ),
//                createPersonRow(
//                    index = 1,
//                    name = "Drew"
//                ),
//                createPersonRow(
//                    index = 2,
//                    name = "Julie"
//                ),
//                createLoader(),
                createVerticalSpace(64),
                createBigButton(
                    buttonText = getString(R.string.everyone_has_joined),
                    clickListener = {
                        Toast.makeText(this, "joined!", Toast.LENGTH_SHORT).show()
                    }
                ),
                createVerticalSpace(64),
                createBigButton(
                    buttonText = getString(R.string.join_decision_instead),
                    clickListener = {
                        Toast.makeText(this, "join instead!", Toast.LENGTH_SHORT).show()
                    }
                )
            )
        )

    }
}
