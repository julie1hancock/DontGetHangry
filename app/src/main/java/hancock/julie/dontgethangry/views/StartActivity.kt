package hancock.julie.dontgethangry.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startPageArrow.setOnClickListener{
            startActivity(Intent(this, InstructionActivity::class.java))
        }
    }
}
