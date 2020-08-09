package hancock.julie.dontgethangry.start

import android.view.View
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import java.util.*

@EpoxyModelClass(layout = R.layout.model_line)
abstract class LineModel: EpoxyModelWithHolder<LineModel.LineHolder>() {

    override fun bind(holder: LineHolder) {

    }

    inner class LineHolder: EpoxyHolder() {

        override fun bindView(itemView: View) {

        }
    }
}

fun createLine(): EpoxyModel<*> = LineModel_().id(UUID.randomUUID().toString())
