package hancock.julie.dontgethangry.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_instruction.*

class InstructionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction)
        instructionArrow.setOnClickListener{
            startActivity(Intent(this, PickingActivity::class.java))

        }
        entireInstructionScreen.setOnClickListener{
            Toast.makeText(this, "This screen is not meant for clicking.\nHit the bottom right arrow if you're ready to get tappin'!" , Toast.LENGTH_LONG).show()
        }
    }
}
