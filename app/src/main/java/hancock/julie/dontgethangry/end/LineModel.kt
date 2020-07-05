package hancock.julie.dontgethangry.end

import android.content.Context
import android.view.View
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_line.view.*

@EpoxyModelClass(layout = R.layout.model_line)
abstract class LineModel: EpoxyModelWithHolder<LineModel.LineHolder>() {

    @EpoxyAttribute
    var color: Int? = null

    @EpoxyAttribute
    var thickness: Int? = null

    @EpoxyAttribute
    var context: Context? = null

    override fun bind(holder: LineHolder) {
        context?.let{ context -> //TODO: setup view so it's not trash
            color?.let{ holder.line.setBackgroundColor(it) }
        }
    }

    inner class LineHolder: EpoxyHolder() {
        lateinit var line: View

        override fun bindView(itemView: View) {
            line = itemView.line
        }
    }
}

fun createLineModel(
    id: String,
    context: Context? = null,
    color: Int? = null,
    thickness: Int? = null
): EpoxyModel<*> {
    return LineModel_()
        .id(id)
        .color(color)
        .thickness(thickness)
        .context(context)
}
