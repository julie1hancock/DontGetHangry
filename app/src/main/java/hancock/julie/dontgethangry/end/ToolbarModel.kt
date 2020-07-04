package hancock.julie.dontgethangry.end

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_toolbar.view.*

@EpoxyModelClass(layout = R.layout.model_toolbar)

abstract class ToolbarModel: EpoxyModelWithHolder<ToolbarModel.ToolbarHolder>() {

    @EpoxyAttribute
    var topText: CharSequence? = ""

    @EpoxyAttribute
    var bottomText: CharSequence? = ""

    @EpoxyAttribute
    var buttonImg: Int? = 0 //todo: make list?

    @EpoxyAttribute
    var buttonListener: (()->Unit)? = null


    override fun bind(holder: ToolbarHolder) {
        holder.topText.text = topText
        holder.bottomText.text = bottomText
        holder.image.setVisibility(!(buttonImg == null || buttonListener == null))
        buttonImg?.let { holder.image.setImageResource(it) }
        buttonListener?.let {
            holder.image.setOnClickListener{ buttonListener?.invoke() }
        }
    }

    inner class ToolbarHolder: EpoxyHolder() {
        lateinit var topText: TextView
        lateinit var bottomText: TextView
        lateinit var image: ImageView

        override fun bindView(itemView: View) {
            topText = itemView.topText
            bottomText = itemView.bottomText
            image = itemView.image
        }
    }
}

fun createToolbarModel(
    topText: String = "Don't Get Hangry",
    bottomText: String,
    buttonImg: Int? = null,
    buttonListener: (()->Unit)? = null
): EpoxyModel<*> {
    return ToolbarModel_()
        .id(topText.hashCode())
        .topText(topText)
        .bottomText(bottomText)
        .buttonImg(buttonImg)
        .buttonListener(buttonListener)
}