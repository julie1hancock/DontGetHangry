package hancock.julie.dontgethangry.end

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyModel
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.decisions.DecisionActivity
import hancock.julie.dontgethangry.models.Singleton
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
        models.add(createToolbarModel(topText = presentation.getTitle(resources), bottomText = presentation.getSubtitle(resources)))

        if(Singleton.diningAlone) setupDiningAloneModels()
        else setupDiningTogetherModels()

        models.add(createSingleButtonRowModel(
            resources.getString(R.string.start_over)
        ) {
            Singleton.youPicked.clear()
            startActivity(Intent(this@EndActivity, DecisionActivity::class.java))
        })

        end_rv.setModels(models)
    }

    private fun setupDiningTogetherModels() {
        if (presentation.hangerAvoided()) {
            models.add(createTextViewModel(resources.getString(R.string.you_both_said_yes)))
            presentation.getOverlapping().forEach {
                models.add(createRestaurantRowModel(it, this@EndActivity))
                models.add(createLineModel(id = it.hashCode().toString()))
            }
        } else {
            models.add(createTextViewModel(resources.getString(R.string.no_matching)))
            models.add(createLineModel(id = "together_line"))
            models.add(createTextViewModel(resources.getString(R.string.you_picked)))
            Singleton.youPicked.forEach {
                models.add(createRestaurantRowModel(it, this@EndActivity))
                models.add(createLineModel(id = it.hashCode().toString()))
            }
            models.add(createTextViewModel(resources.getString(R.string.they_picked)))
            Singleton.theyPicked.forEach {
                models.add(createRestaurantRowModel(it, this@EndActivity))
                models.add(createLineModel(id = it.hashCode().toString()))
            }
        }
    }

    private fun setupDiningAloneModels() {
        if (presentation.hangerAvoided()) {
            models.add(createTextViewModel(resources.getString(R.string.matching_alone)))
            models.add(createLineModel("alone_line"))
            Singleton.youPicked.forEach {
                models.add(createRestaurantRowModel(it, this@EndActivity))
                models.add(createLineModel(id = it.hashCode().toString()))
            }
        } else {
            models.add(createTextViewModel(resources.getString(R.string.no_matching_alone)))
        }
    }

}

