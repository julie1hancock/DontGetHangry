package hancock.julie.dontgethangry.models

import android.view.View

fun View?.setVisibility(isVisible: Boolean) {
    this?.visibility = if(isVisible) View.VISIBLE else View.GONE
}

fun createPostfix(address: String) =
    address
        .replace(",","")
        .replace("\\w+"," ")
        .split(" ")
        .joinToString("+")