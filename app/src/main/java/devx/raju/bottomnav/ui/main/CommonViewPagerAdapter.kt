package devx.raju.bottomnav.ui.main

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CommonViewPagerAdapter(fragmentManager: FragmentManager, private val viewPagerItems: ArrayList<ViewPagerItem>) : FragmentPagerAdapter(fragmentManager) {

    private var pageTitles = arrayListOf<String>()

    init {
        for (title in viewPagerItems) {
            pageTitles.add(title.title)
        }
    }

    override fun getItem(pos: Int) = viewPagerItems[pos].fragment

    fun updateTabTitle(titleList: ArrayList<String>) {
        pageTitles = titleList
        notifyDataSetChanged()
    }

    override fun getCount() = viewPagerItems.size

    override fun getPageTitle(position: Int) = pageTitles[position]
}