package hancock.julie.dontgethangry.start

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_text.view.*

@EpoxyModelClass(layout = R.layout.model_text)
abstract class TextModel: EpoxyModelWithHolder<TextModel.TextHolder>() {

    @EpoxyAttribute
    var text: CharSequence? = "!!"

    @EpoxyAttribute
    var textType : TextType? = null

    @EpoxyAttribute
    var center : Boolean? = false


    override fun bind(holder: TextHolder) {
        holder.textView.text = text
    }

    inner class TextHolder: EpoxyHolder() {
        lateinit var textView: TextView

        override fun bindView(itemView: View) {
            textView = itemView.text
        }
    }
}

enum class TextType {
    Text4,
    Text5,
    Subtext6
}

fun createText(
    text: String,
    textType: TextType,
    center: Boolean = true
): EpoxyModel<*> {
    return TextModel_()
        .id(text.hashCode())
        .textType(textType)
        .center(center)
        .text(text)
}