package hancock.julie.dontgethangry.start

import android.content.Context
import android.content.Intent
import android.widget.Toast

interface StartCoordination {
    fun launchStart(context: Context)
    fun launchCreateDecision(context: Context)
    fun launchJoinDecision(context: Context)
    fun launchNameEntry(context: Context)
    fun launchNext(context: Context)
}

class StartCoordinator : StartCoordination {
    override fun launchNext(context: Context) {
        Toast.makeText(context, "launch next!@#", Toast.LENGTH_SHORT).show()
    }

    override fun launchStart(context: Context) {
        context.startActivity(Intent(context, StartActivity::class.java))
    }

    override fun launchCreateDecision(context: Context) {
        context.startActivity(Intent(context, CreateDecisionActivity::class.java))
    }

    override fun launchJoinDecision(context: Context) {
        context.startActivity(Intent(context, JoinDecisionActivity::class.java))
    }

    override fun launchNameEntry(context: Context) {
        context.startActivity(Intent(context, NameActivity::class.java))
    }

}