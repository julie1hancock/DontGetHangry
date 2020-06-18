package hancock.julie.dontgethangry.helpers

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler

class Run {
    companion object {
        fun after(delay: Long, process: () -> Unit) {
            Handler().postDelayed({
                process()
            }, delay)
        }
    }
}

fun startExternal(url: String, context: Context){
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse(url)
    context.startActivity(openURL)
}