package hancock.julie.dontgethangry.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.activity_epoxy.*
import kotlinx.android.synthetic.main.toolbar.view.*

class JoinDecisionActivity : AppCompatActivity() {

    //todo inject
    lateinit var presenter: StartPresentation
    lateinit var coordinator: StartCoordination

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)
        toolbar.toolbarTitle.text = getString(R.string.join_decision_group)
        presenter = StartPresenter()
        coordinator = StartCoordinator()
        epoxyRv.setModels(presenter.generateEpoxyModelsForDecision(
            context = this,
            isCreate = false,
            coordinator = coordinator
        ))
    }
}
