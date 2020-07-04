package hancock.julie.dontgethangry.end.no

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import kotlinx.android.synthetic.main.rest_view_old.view.*

class EndAdapter(private val rests: List<Restaurant>, private val context: Context) :
    RecyclerView.Adapter<EndAdapter.EndHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EndHolder {
        return EndHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rest_view_old,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = rests.size

    override fun onBindViewHolder(holder: EndHolder, position: Int) {
        holder.name.text = rests[position].name
        holder.icon.setImageResource(rests[position].image)
        holder.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=${createPostfix(rests[position].address)}"))
            context.startActivity(intent)
        }
    }

    private fun createPostfix(address: String) =
        address
            .replace(",","")
            .replace("\\w+"," ")
            .split(" ")
            .joinToString("+")


    class EndHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.endRestName
        val icon: ImageView = v.endRestIcon
        val root: ConstraintLayout = v.endRoot
    }
}