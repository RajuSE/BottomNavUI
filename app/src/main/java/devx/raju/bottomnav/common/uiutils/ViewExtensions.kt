package devx.raju.bottomnav.common.uiutils

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import devx.raju.bottomnav.R
import devx.raju.bottomnav.common.HelperMethods

fun View?.panWithCallback(animationListener: Animation.AnimationListener) {
    val anim = ScaleAnimation(
            1f, 0.8f,
            1f, 0.8f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
    anim.fillAfter = true
    anim.duration = 70

    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {

        }

        override fun onAnimationEnd(animation: Animation) {
            val anim1 = ScaleAnimation(
                    0.8f, 1f,
                    0.8f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f)
            anim1.fillAfter = true
            anim1.duration = 70
            anim1.setAnimationListener(animationListener)
            this@panWithCallback?.startAnimation(anim1)
        }

        override fun onAnimationRepeat(animation: Animation) {

        }
    })

    this?.startAnimation(anim)
}

fun ViewGroup?.panWithCallback(animationListener: Animation.AnimationListener) {
    val anim = ScaleAnimation(
            1f, 0.8f,
            1f, 0.8f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
    anim.fillAfter = true
    anim.duration = 100

    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {

        }

        override fun onAnimationEnd(animation: Animation) {
            val anim1 = ScaleAnimation(
                    0.8f, 1f,
                    0.8f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f)
            anim1.fillAfter = true
            anim1.duration = 100
            anim1.setAnimationListener(animationListener)
            this@panWithCallback?.startAnimation(anim1)
        }

        override fun onAnimationRepeat(animation: Animation) {

        }
    })

    this?.startAnimation(anim)
}

fun RecyclerView?.setLayAnimation(resId: Int = R.anim.layout_animation_falldown) {
    if (this@setLayAnimation != null) {
        HelperMethods.setRecyclerAnim(this, this.context, resId)
    }
}

