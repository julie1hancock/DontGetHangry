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
        left.setOnClickListener{
            Toast.makeText(this, "That says you DID pick the current restaurant" , Toast.LENGTH_SHORT).show()
        }
        right.setOnClickListener{
            Toast.makeText(this, "That says you did NOT pick the current restaurant" , Toast.LENGTH_SHORT).show()
        }
        bottom.setOnClickListener{
            Toast.makeText(this, "That will show more info on the current restaurant" , Toast.LENGTH_SHORT).show()
        }
        undoCardView.setOnClickListener{
            Toast.makeText(this, "That will undo your last choice" , Toast.LENGTH_SHORT).show()
        }
//        checkCardView.setOnClickListener{
//            Toast.makeText(this, "This icon will remain while you're picking to help you remember where to tap.\nClicking it or any area currently green will say YES to the current restaurant.", Toast.LENGTH_LONG).show()
//        }
//        xCardView.setOnClickListener{
//            Toast.makeText(this, "This icon will remain while you're picking to help you remember where to tap.\nClicking it or any area currently red will say NO to the current restaurant.", Toast.LENGTH_LONG).show()
//        }
//        infoCardView.setOnClickListener{
//            Toast.makeText(this, "This icon will remain while you're picking to help you remember where to tap.\nClicking it or any area currently blue will show you more information on the current restaurant.", Toast.LENGTH_LONG).show()
//        }

    }
}
