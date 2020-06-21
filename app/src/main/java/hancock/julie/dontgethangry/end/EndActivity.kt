package hancock.julie.dontgethangry.end

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.filter.FilterActivity
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {

    lateinit var presentation: EndPresentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        presentation = EndPresenter() //TODO: inject
        setupView()
    }

    private fun setupView() {
        toolbarSubtitle.text = presentation.getSubText(resources)
        if(presentation.cantNavigate()) nav_instructions.text = ""
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentLayout, presentation.getFragment())//.replace
            .commit()

//        var fragment = presentation.getFragment()
        startOverBtn.setOnClickListener{
            startActivity(Intent(this, FilterActivity::class.java))
        }
    }

}

