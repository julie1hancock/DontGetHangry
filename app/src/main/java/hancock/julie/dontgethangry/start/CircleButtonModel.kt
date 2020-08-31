package hancock.julie.dontgethangry.start

import android.content.Context
import android.view.View
import android.widget.ImageButton
import com.airbnb.epoxy.*
import hancock.julie.dontgethangry.R
import kotlinx.android.synthetic.main.model_circle_button.view.*

@EpoxyModelClass(layout = R.layout.model_circle_button)
abstract class CircleButtonModel: EpoxyModelWithHolder<CircleButtonModel.CircleButtonHolder>() {

    @EpoxyAttribute
    var context: Context? = null

    @EpoxyAttribute
    var icon: Icons? = Icons.Next

    @EpoxyAttribute
    var location: Locations? = Locations.BottomRight

    @EpoxyAttribute
    var clickListener: (()->Unit)? = null

    override fun bind(holder: CircleButtonHolder) {

        holder.button.setBackgroundResource(when(icon){
            Icons.Next -> R.drawable.next_button
            Icons.Check -> R.drawable.check_button
            Icons.X -> R.drawable.x_button
            Icons.Question -> R.drawable.question_button
            else -> R.drawable.default_button
        })

        //todo: location

        holder.button.setOnClickListener{ clickListener?.invoke() }
    }

    inner class CircleButtonHolder: EpoxyHolder() {
        lateinit var button: ImageButton

        override fun bindView(itemView: View) {
            button = itemView.button
        }
    }
}

enum class Icons { Next, Check, X, Question }
enum class Locations { TopLeft, TopRight, BottomLeft, BottomRight }


fun createCircleButton(
    icon: Icons,
    location: Locations,
    clickListener: (()->Unit)?
): EpoxyModel<*> {
    return CircleButtonModel_()
        .id(clickListener.hashCode())
        .icon(icon)
        .location(location)
        .clickListener(clickListener)
}