package hancock.julie.dontgethangry.old.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hancock.julie.dontgethangry.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_old)
        startActivity(Intent(this, StartActivity::class.java))
    }
}
