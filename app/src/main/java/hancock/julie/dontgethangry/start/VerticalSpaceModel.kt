package hancock.julie.dontgethangry.start

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_vertical_view.view.*
import java.util.*

@EpoxyModelClass(layout = R.layout.model_vertical_view)
abstract class VerticalSpaceModel: EpoxyModelWithHolder<VerticalSpaceModel.VerticalSpaceHolder>() {

    @EpoxyAttribute
    var space: Int? = 8


    override fun bind(holder: VerticalSpaceHolder) {
        holder.view.layoutParams = ConstraintLayout.LayoutParams(
            1, space?:1
        )
    }

    inner class VerticalSpaceHolder: EpoxyHolder() {
        lateinit var view: View

        override fun bindView(itemView: View) {
            view = itemView.view
        }
    }
}

fun createVerticalSpace(
    height: Int
): EpoxyModel<*> {
    return VerticalSpaceModel_()
        .id(UUID.randomUUID().toString())
        .space(height)
}