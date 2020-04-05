package hancock.julie.dontgethangry.views

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_picking.*
import kotlinx.android.synthetic.main.content_picking.*

class PickingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picking)
        setSupportActionBar(toolbar)
        setupListening()

    }

    private fun setupListening() {
        left.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            Toast.makeText(this, "left", Toast.LENGTH_SHORT).show()
            true
        }
        right.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
            true
        }

    }


}
