package hancock.julie.dontgethangry.models.epoxy

import android.view.View
import android.widget.Button
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_single_button_row.view.*

@EpoxyModelClass(layout = R.layout.model_single_button_row)
abstract class SingleButtonRowModel: EpoxyModelWithHolder<SingleButtonRowModel.SingleButtonRowHolder>() {

    @EpoxyAttribute
    var buttonText: CharSequence? = ""

    @EpoxyAttribute
    var clickListener: (()->Unit)? = null

    override fun bind(holder: SingleButtonRowHolder) {
        holder.button.text = buttonText
        holder.button.setOnClickListener{ clickListener?.invoke() }
    }

    inner class SingleButtonRowHolder: EpoxyHolder() {
        lateinit var button: Button

        override fun bindView(itemView: View) {
            button = itemView.button
        }
    }
}

fun createSingleButtonRowModel(
    buttonText: String,
    clickListener: (()->Unit)
): EpoxyModel<*> {
    return SingleButtonRowModel_()
        .id(clickListener.hashCode())
        .buttonText(buttonText)
        .clickListener(clickListener)
}