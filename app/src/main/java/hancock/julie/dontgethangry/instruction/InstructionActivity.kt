package hancock.julie.dontgethangry.instruction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.start.NameActivity
import hancock.julie.dontgethangry.start.StartActivity
import kotlinx.android.synthetic.main.activity_instruction.*

class InstructionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction)
        nextArrow.setOnClickListener{
            startActivity(Intent(this, NameActivity::class.java)) //todo coordinator/inject
        }
    }
}

