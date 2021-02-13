package devx.raju.bottomnav.common

import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

object HelperMethods {

    fun getRandomColor(): String {
        val colorList = arrayListOf<String>()
        colorList.add("#C7F964")
        colorList.add("#68BE99")
        colorList.add("#3BDA02")
        colorList.add("#C7F964")

        val randomNumber = Random.nextInt(colorList.size)
        return colorList[randomNumber]
    }


    fun setRecyclerAnim(
        recyclerView: RecyclerView,
        context: Context?,
        resId: Int
    ) {
        val animation =
            AnimationUtils.loadLayoutAnimation(context, resId)
        recyclerView.layoutAnimation = animation
    }

}