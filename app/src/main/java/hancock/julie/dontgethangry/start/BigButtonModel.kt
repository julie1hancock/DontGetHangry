package hancock.julie.dontgethangry.start

import android.view.View
import android.widget.Button
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_big_button.view.*

@EpoxyModelClass(layout = R.layout.model_big_button)
abstract class BigButtonModel: EpoxyModelWithHolder<BigButtonModel.BigButtonHolder>() {

    @EpoxyAttribute
    var buttonText: CharSequence? = ""

    @EpoxyAttribute
    var clickListener: (()->Unit)? = null

    override fun bind(holder: BigButtonHolder) {
        holder.button.text = buttonText
        holder.button.setOnClickListener{ clickListener?.invoke() }
    }

    inner class BigButtonHolder: EpoxyHolder() {
        lateinit var button: Button

        override fun bindView(itemView: View) {
            button = itemView.button
        }
    }
}

fun createBigButton(
    buttonText: String,
    clickListener: (()->Unit)
): EpoxyModel<*> {
    return BigButtonModel_()
        .id(clickListener.hashCode())
        .buttonText(buttonText)
        .clickListener(clickListener)
}