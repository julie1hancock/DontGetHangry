package hancock.julie.dontgethangry.end

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.filter.FilterActivity
import kotlinx.android.synthetic.main.activity_instruction.*

class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        nextArrow.setOnClickListener{
            startActivity(Intent(this, FilterActivity::class.java))
        }

    }
}

