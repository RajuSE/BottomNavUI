package devx.raju.bottomnav.ui.main

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import devx.raju.bottomnav.R
import devx.raju.bottomnav.ui.main.dashboard.DashboardFragment
import devx.raju.bottomnav.ui.main.home.HomeFragment
import devx.raju.bottomnav.ui.main.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = arrayListOf<ViewPagerItem>()
        fragmentList.add(ViewPagerItem(HomeFragment(), ""))
        fragmentList.add(ViewPagerItem(DashboardFragment(), ""))
        fragmentList.add(ViewPagerItem(NotificationsFragment(), ""))
        viewPager.adapter = CommonViewPagerAdapter(supportFragmentManager, fragmentList)
        viewPager.offscreenPageLimit = 2

        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home ->
                    viewPager.currentItem = 0
                R.id.navigation_dashboard ->
                    viewPager.currentItem = 1
                else ->
                    viewPager.currentItem = 2

            }
            return@setOnNavigationItemSelectedListener true
        }

        setCustomStatusBar(this@MainActivity, R.drawable.rectangle0_drawable)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    setCustomStatusBar(this@MainActivity, R.drawable.rectangle0_drawable)
                } else if (position == 1) {
                    setCustomStatusBar(this@MainActivity, R.drawable.rectangle1_drawable)
                }else{
                    setCustomStatusBar(this@MainActivity, R.drawable.rectangle2_drawable)
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

        })
    }



    fun setCustomStatusBar(
        activity: Activity,
        drawableId: Int
    ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val window = activity.window
                val view = activity.window.decorView
                val background = ContextCompat.getDrawable(this, drawableId)

                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = activity.resources.getColor(android.R.color.transparent)
//            window.navigationBarColor = activity.resources.getColor(android.R.color.transparent)
                window.setBackgroundDrawable(background)
            }
    }
}