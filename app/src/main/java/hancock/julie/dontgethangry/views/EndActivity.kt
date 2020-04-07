package hancock.julie.dontgethangry.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.presenters.EndPresenter
import kotlinx.android.synthetic.main.activity_end.*
import kotlinx.android.synthetic.main.activity_picking.toolbar
import kotlinx.android.synthetic.main.rest_view.view.*

class EndActivity : AppCompatActivity() {

    lateinit var presenter: EndPresenter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        setSupportActionBar(toolbar)
        presenter = EndPresenter()

        if(presenter.isWinning()) {
            setupWinView()
        }
        else {
            setupLoseView()
        }

        setupBtnListener()
    }

    private fun setupBtnListener() {
        startOverBtnWin.setOnClickListener{
            Singleton.youPicked.clear()
            Singleton.youRejected.clear()
            startActivity(Intent(this, PickingActivity::class.java))
            finish()
        }
        startOverBtnLose.setOnClickListener{
            Singleton.youPicked.clear()
            Singleton.youRejected.clear()
            startActivity(Intent(this, PickingActivity::class.java))
            finish()
        }
    }

    private fun setupWinView() {
        winningLayout.visibility = View.VISIBLE
        startOverBtnWin.visibility = View.VISIBLE
        startOverBtnLose.visibility = View.GONE
        losingLayout.visibility = View.GONE

        linearLayoutManager = LinearLayoutManager(this)
        winningRV.layoutManager = linearLayoutManager

        winningRV.adapter = EndAdapter(presenter.overlappingRests, this)
    }

    private fun setupLoseView() {
        winningLayout.visibility = View.GONE
        startOverBtnWin.visibility = View.GONE
        startOverBtnLose.visibility = View.VISIBLE
        losingLayout.visibility = View.VISIBLE

        linearLayoutManager = LinearLayoutManager(this)
        theyPickedRV.layoutManager = linearLayoutManager
        linearLayoutManager = LinearLayoutManager(this)
        youPickedRV.layoutManager = linearLayoutManager

        youPickedRV.adapter = EndAdapter(Singleton.youPicked, this)
        theyPickedRV.adapter = EndAdapter(Singleton.theyPicked, this)
    }

}

class EndAdapter(private val rests: List<Restaurant>, val context: Context) :
    RecyclerView.Adapter<EndAdapter.EndHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EndHolder {
        return EndHolder(LayoutInflater.from(context).inflate(R.layout.rest_view, parent, false))
    }

    override fun getItemCount() = rests.size

    override fun onBindViewHolder(holder: EndHolder, position: Int) {
        holder.name.text = rests[position].name
        holder.icon.setImageResource(R.drawable.ic_location_foreground)
        holder.navigationRoot.setOnClickListener {
            Toast.makeText(context, rests[position].address, Toast.LENGTH_SHORT).show()
        }
    }

    class EndHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.restLineRestName
        val icon = v.restLineMarkerIcon
        val navigationRoot = v.navigationLayout
    }
}