package hancock.julie.dontgethangry.end

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_text.view.*

@EpoxyModelClass(layout = R.layout.model_text)
abstract class TextViewModel: EpoxyModelWithHolder<TextViewModel.TextViewHolder>() {

    @EpoxyAttribute
    var text: CharSequence? = ""

    override fun bind(holder: TextViewHolder) {
        holder.textView.text = text
    }

    inner class TextViewHolder: EpoxyHolder() {
        lateinit var textView: TextView

        override fun bindView(itemView: View) {
            textView = itemView.text
        }
    }
}

fun createTextViewModel(
    text: String
): EpoxyModel<*> {
    return TextViewModel_()
        .id(text.hashCode())
        .text(text)
}
