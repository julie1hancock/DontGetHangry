package hancock.julie.dontgethangry.start

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_epoxy.*
import kotlinx.android.synthetic.main.toolbar.view.*

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)
        toolbar.toolbarTitle.text = getString(R.string.welcome)

        epoxyRv.setModels(
            listOf(
                createVerticalSpace(128),
                createBigButton(
                    buttonText = getString(R.string.create_decision),
                    clickListener = {
                        startActivity(Intent(this, CreateDecisionActivity::class.java))
                    }
                ),
                createVerticalSpace(128),
                createBigButton(
                    buttonText = getString(R.string.join_decision),
                    clickListener = {
                        Toast.makeText(this,"join", Toast.LENGTH_SHORT).show()
                    }
                ),
                createVerticalSpace(128),
                createBigButton(
                    buttonText = getString(R.string.dine_alone),
                    clickListener = {
                        Toast.makeText(this,"alone", Toast.LENGTH_SHORT).show()
                    }
                )
            )
        )

    }
}

