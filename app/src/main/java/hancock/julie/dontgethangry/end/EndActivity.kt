package hancock.julie.dontgethangry.end

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyModel
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {

    lateinit var presentation: EndPresentation
    var models = mutableListOf<EpoxyModel<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        presentation = EndPresenter() //TODO: inject
        setupView()
    }

    private fun setupView() {
        models = mutableListOf()
        models.add(createToolbarModel(bottomText = presentation.getSubText(resources)))
        presentation.getOverlapping().forEach {
            models.add(createRestaurantRowModel(it,this@EndActivity))
        }

        end_rv.setModels(models)

//        toolbarSubtitle.text = presentation.getSubText(resources)
//        startOverBtn.setOnClickListener{
//            startActivity(Intent(this, FilterActivity::class.java))
//        }
//
//        val list= mutableListOf<Rest>(
//            Rest("one"),
//            Rest("two"),
//            Rest("three"),
//            Rest("four"),
//            Rest("five")
//        )
//
//        main_activity_raffle_rv.withModels {
//            list.forEach {
//                    rest {
//                        id(hashCode())
//                        name(it.name)
//                    }
//                }
//            }
//        }




//        if(presentation.cantNavigate()) nav_instructions.text = ""
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragmentLayout, presentation.getFragment())//.replace
//            .commit()

//        var fragment = presentation.getFragment()

    }

}

