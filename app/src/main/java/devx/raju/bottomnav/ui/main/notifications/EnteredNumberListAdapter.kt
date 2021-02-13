package devx.raju.bottomnav.ui.main.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devx.raju.bottomnav.R
import devx.raju.bottomnav.ui.main.NumData
import kotlinx.android.synthetic.main.item_entered_num.view.*

class EnteredNumberListAdapter(
    private val context: Context,
    var itemList: ArrayList<NumData>
) :
    RecyclerView.Adapter<EnteredNumberListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_entered_num, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemList[position]

        holder.displayTitle.text = data.num.toString()
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val displayTitle: TextView = itemView.displayTitle
    }
}