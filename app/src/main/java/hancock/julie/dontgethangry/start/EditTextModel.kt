package hancock.julie.dontgethangry.start

import android.annotation.SuppressLint
import android.view.View
import android.widget.EditText
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_edit_text.view.*

@EpoxyModelClass(layout = R.layout.model_edit_text)
abstract class EditTextModel: EpoxyModelWithHolder<EditTextModel.EditTextHolder>() {

    @EpoxyAttribute
    var hint: CharSequence? = ""

    @SuppressLint("SetTextI18n")
    override fun bind(holder: EditTextHolder) {
        holder.edit.hint = hint
    }

    inner class EditTextHolder: EpoxyHolder() {
        lateinit var edit: EditText

        override fun bindView(itemView: View) {
            edit = itemView.editText
        }
    }
}

fun createEditText(
    hint: String = ""
): EpoxyModel<*> {
    return EditTextModel_()
        .id(hint.hashCode())//todo - more random?
        .hint(hint)
}