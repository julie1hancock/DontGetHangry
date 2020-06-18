package hancock.julie.dontgethangry.old.helpers

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Toast
import hancock.julie.dontgethangry.R

fun View.toastListener(str: String, context: Context){
    this.setOnClickListener{
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }
}

fun View.setVisibleOrGone(b: Boolean) {
    this.visibility = if(b) View.VISIBLE
    else View.GONE
}


fun View.setColor(isGreen: Boolean?, resources: Resources) {
    when {
        isGreen == null -> setBackgroundColor(resources.getColor(R.color.mutedYellow))
        isGreen -> setBackgroundColor(resources.getColor(R.color.mutedGreen))
        else -> setBackgroundColor(resources.getColor(R.color.mutedRed))
    }

}