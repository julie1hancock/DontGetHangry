package hancock.julie.dontgethangry.filter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.decisions.DecisionActivity
import kotlinx.android.synthetic.main.activity_instruction.*

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        nextArrow.setOnClickListener{
            startActivity(Intent(this, DecisionActivity::class.java))
        }
    }
}

