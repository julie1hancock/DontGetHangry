package hancock.julie.dontgethangry.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hancock.julie.dontgethangry.R
import hancock.julie.dontgethangry.models.Restaurant
import hancock.julie.dontgethangry.models.Singleton
import hancock.julie.dontgethangry.presenters.EndPresenter
import kotlinx.android.synthetic.main.activity_end.*
import kotlinx.android.synthetic.main.activity_picking.toolbar
import kotlinx.android.synthetic.main.rest_view.view.*

class EndActivity : AppCompatActivity() {

    private lateinit var presenter: EndPresenter

    private lateinit var gridLayoutManager: GridLayoutManager

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
        toolbarTitle.text = "Hanger Avoided!"
        winningLayout.visibility = View.VISIBLE
        startOverBottomLayoutWin.visibility = View.VISIBLE
        startOverBottomLayoutLose.visibility = View.GONE
        losingLayout.visibility = View.GONE

        gridLayoutManager = GridLayoutManager(this,3)
        winningRV.layoutManager = gridLayoutManager

        winningRV.adapter = EndAdapter(presenter.overlappingRests, this)
    }

    private fun setupLoseView() {
        toolbarTitle.text = "Hanger Not Avoided!"
        winningLayout.visibility = View.GONE
        startOverBottomLayoutWin.visibility = View.GONE
        startOverBottomLayoutLose.visibility = View.VISIBLE
        losingLayout.visibility = View.VISIBLE

        gridLayoutManager = GridLayoutManager(this,3)
        theyPickedRV.layoutManager = gridLayoutManager
        gridLayoutManager = GridLayoutManager(this,3)
        youPickedRV.layoutManager = gridLayoutManager

        youPickedRV.adapter = EndAdapter(Singleton.youPicked, this)
        theyPickedRV.adapter = EndAdapter(Singleton.theyPicked, this)
    }

}

class EndAdapter(private val rests: List<Restaurant>, private val context: Context) :
    RecyclerView.Adapter<EndAdapter.EndHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EndHolder {
        return EndHolder(LayoutInflater.from(context).inflate(R.layout.rest_view, parent, false))
    }

    override fun getItemCount() = rests.size

    override fun onBindViewHolder(holder: EndHolder, position: Int) {
        holder.name.text = rests[position].name
        holder.icon.setImageResource(rests[position].image)
        holder.root.setOnClickListener {
            Toast.makeText(context, rests[position].address, Toast.LENGTH_SHORT).show()
        }
    }

    class EndHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.endRestName
        val icon: ImageView = v.endRestIcon
        val root: ConstraintLayout = v.endRoot
    }
}