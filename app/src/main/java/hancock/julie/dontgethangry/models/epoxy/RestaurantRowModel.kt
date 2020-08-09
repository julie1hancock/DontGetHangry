package hancock.julie.dontgethangry.models.epoxy

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
import hancock.julie.dontgethangry.models.createPostfix
import kotlinx.android.synthetic.main.model_restaurant_row.view.*
import kotlinx.android.synthetic.main.model_toolbar.view.image

@EpoxyModelClass(layout = R.layout.model_restaurant_row)
abstract class RestaurantRowModel: EpoxyModelWithHolder<RestaurantRowModel.RestaurantRowHolder>() {

    @EpoxyAttribute
    var restaurant: Restaurant? = null

    @EpoxyAttribute
    var context: Context? = null

    override fun bind(holder: RestaurantRowHolder) {
        restaurant?.let{
            holder.image.setImageResource(it.getDisplayImage())
            holder.name.text = it.getDisplayName()
            holder.address.text = it.getDisplayAddress()
            holder.milesAway.text = it.getDisplayMilesAway()
            holder.root.setOnClickListener{ view->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=${createPostfix(
                    it.address
                )}"))
                context?.startActivity(intent)
            }
        }
    }

    inner class RestaurantRowHolder: EpoxyHolder() {
        lateinit var image: ImageView
        lateinit var name: TextView
        lateinit var address: TextView
        lateinit var milesAway: TextView
        lateinit var root: ConstraintLayout

        override fun bindView(itemView: View) {
            image = itemView.image
            name = itemView.name
            address = itemView.address
            milesAway = itemView.milesAway
            root = itemView.root
        }
    }
}

fun createRestaurantRowModel(
    restaurant: Restaurant,
    context: Context
): EpoxyModel<*> {
    return RestaurantRowModel_()
        .id(restaurant.hashCode())
        .restaurant(restaurant)
        .context(context)
}

