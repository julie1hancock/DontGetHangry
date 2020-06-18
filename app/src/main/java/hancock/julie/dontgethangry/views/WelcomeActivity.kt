package hancock.julie.dontgethangry.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.presenters.InstructionPresentation
import kotlinx.android.synthetic.main.activity_start.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startPageArrow.setOnClickListener{
            InstructionPresentation().startActivity(this)
        }
    }
}
