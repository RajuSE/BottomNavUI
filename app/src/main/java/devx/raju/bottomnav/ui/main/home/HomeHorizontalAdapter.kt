package devx.raju.bottomnav.ui.main.home

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import devx.raju.bottomnav.R
import devx.raju.bottomnav.ui.main.ItemData
import devx.raju.bottomnav.common.HelperMethods
import devx.raju.bottomnav.common.uiutils.panWithCallback
import kotlinx.android.synthetic.main.item_horizontal_list.view.*

class HomeHorizontalAdapter(
    private val context: Context,
    private val itemList: Array<ItemData>
) :
    RecyclerView.Adapter<HomeHorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_horizontal_list_hiphop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemList[position]

        holder.displayTitle.text = data.displayTitle
        holder.displayText.text = data.displayText

        holder.itemLayout.setOnClickListener {
            holder.itemLayout.panWithCallback(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    Toast.makeText(
                        context,
                        "Title: " + itemList[holder.adapterPosition].displayTitle,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAnimationStart(p0: Animation?) {
                }
            })

        }
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemLayout: ConstraintLayout = itemView.itemLayout
        val displayTitle: TextView = itemView.displayTitle
        val displayText: TextView = itemView.displayText
    }
}