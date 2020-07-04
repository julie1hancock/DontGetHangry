package hancock.julie.dontgethangry.end

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import kotlinx.android.synthetic.main.model_restaurant_row.view.*
import kotlinx.android.synthetic.main.model_toolbar.view.*
import kotlinx.android.synthetic.main.model_toolbar.view.image

@EpoxyModelClass(layout = R.layout.model_line)
abstract class LineModel: EpoxyModelWithHolder<LineModel.LineHolder>() {

    @EpoxyAttribute
    var color: Int? = null

    @EpoxyAttribute
    var thickness: Int? = null

    @EpoxyAttribute
    var context: Context? = null

    override fun bind(holder: LineHolder) {
        context?.let{context ->
//            holder.line.hei
//            holder.line.height = thickness
            color?.let{ holder.line.setBackgroundColor(it) }
        }

//        restaurant?.let{
//            holder.image.setImageResource(it.getDisplayImage())
//            holder.name.text = it.getDisplayName()
//            holder.address.text = it.getDisplayAddress()
//            holder.milesAway.text = it.getDisplayMilesAway()
//            holder.root.setOnClickListener{ view->
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=${createPostfix(it.address)}"))
//                context?.startActivity(intent)
//            }
//        }
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

