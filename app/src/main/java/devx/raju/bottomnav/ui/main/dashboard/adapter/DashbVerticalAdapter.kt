package devx.raju.bottomnav.ui.main.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import devx.raju.bottomnav.R
import kotlinx.android.synthetic.main.item_vertical_grid.view.*

class SecondRecyclerViewAdapter(
    private val context: Context,
    private val itemList: Array<String>
) :
    RecyclerView.Adapter<SecondRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_vertical_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemList[position]

        holder.displayText.text = data

        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                "Title: " + itemList[holder.adapterPosition],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val displayText: TextView = itemView.displayText
    }
}