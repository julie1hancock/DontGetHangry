package hancock.julie.dontgethangry.old.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.old.presenters.InstructionPresentation
import kotlinx.android.synthetic.main.activity_start_old.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_old)
        startPageArrow.setOnClickListener{
            InstructionPresentation().startActivity(this)
        }
    }
}
