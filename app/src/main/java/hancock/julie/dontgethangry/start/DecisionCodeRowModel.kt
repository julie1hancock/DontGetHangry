package hancock.julie.dontgethangry.start

import android.annotation.SuppressLint
import android.view.View
import android.widget.EditText
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_decision_code_row.view.*
import kotlinx.android.synthetic.main.single_edit_text.view.*

@EpoxyModelClass(layout = R.layout.model_decision_code_row)
abstract class DecisionCodeRowModel: EpoxyModelWithHolder<DecisionCodeRowModel.DecisionCodeRowHolder>() {

    @EpoxyAttribute
    var string: CharSequence? = ""

    @EpoxyAttribute
    var edit : Boolean? = null

    @SuppressLint("SetTextI18n")
    override fun bind(holder: DecisionCodeRowHolder) {
        holder.view0.setText(string.toString()[0] + "")
        holder.view1.setText(string.toString()[1] + "")
        holder.view2.setText(string.toString()[2] + "")
        holder.view3.setText(string.toString()[3] + "")
        holder.view4.setText(string.toString()[4] + "")
        if(edit == true) {
            holder.view0.isFocusable = true
            holder.view1.isFocusable = true
            holder.view2.isFocusable = true
            holder.view3.isFocusable = true
            holder.view4.isFocusable = true
        } else {
            holder.view0.isFocusable = false
            holder.view1.isFocusable = false
            holder.view2.isFocusable = false
            holder.view3.isFocusable = false
            holder.view4.isFocusable = false
        }
    }

    inner class DecisionCodeRowHolder: EpoxyHolder() {
        lateinit var view0: EditText
        lateinit var view1: EditText
        lateinit var view2: EditText
        lateinit var view3: EditText
        lateinit var view4: EditText

        override fun bindView(itemView: View) {
            view0 = itemView.edit0.editText
            view1 = itemView.edit1.editText
            view2 = itemView.edit2.editText
            view3 = itemView.edit3.editText
            view4 = itemView.edit4.editText
        }
    }
}

fun createDecisionCodeRow(
    edit: Boolean,
    string: String
): EpoxyModel<*> {
    return DecisionCodeRowModel_()
        .id(string.hashCode())
        .edit(edit)
        .string(string)
}