package hancock.julie.dontgethangry.decisions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.end.EndActivity
import kotlinx.android.synthetic.main.activity_instruction.*

class DecisionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decision)

        nextArrow.setOnClickListener{
            startActivity(Intent(this, EndActivity::class.java))
        }
    }
}

