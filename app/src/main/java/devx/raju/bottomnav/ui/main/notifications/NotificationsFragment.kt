package devx.raju.bottomnav.ui.main.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.inputmethod.EditorInfo
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import devx.raju.bottomnav.R
import devx.raju.bottomnav.common.uiutils.panWithCallback
import devx.raju.bottomnav.common.uiutils.setLayAnimation
import devx.raju.bottomnav.ui.main.NumData
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment() {

    private lateinit var adapter: EnteredNumberListAdapter
    private lateinit var notificationsViewModel: NotificationsViewModel
    val alist = ArrayList<NumData>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notifications, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)
        adapter = EnteredNumberListAdapter(requireContext(), arrayListOf<NumData>())

        enteredNumRecycler.adapter = adapter
        enteredLayout.isVisible = false
        secondLargLayout.isVisible = false

        enterBtn.setOnClickListener {
            enterBtn.panWithCallback(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    processEnteredNumber()
                }

                override fun onAnimationStart(p0: Animation?) {
                }
            })

        }

        editext.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                processEnteredNumber()
            }
            false
        }


        notificationsViewModel.num.removeObservers(viewLifecycleOwner)
        notificationsViewModel.secLargNum.removeObservers(viewLifecycleOwner)
        notificationsViewModel.updateUI()
        notificationsViewModel.num.observe(viewLifecycleOwner) {
            it.let {
                if (adapter.itemList.isEmpty()) {
                    enteredNumRecycler.setLayAnimation()
                    adapter.itemList = it as ArrayList<NumData>
                    enteredNumRecycler.adapter = adapter

                    enteredLayout.isVisible = true
                    secondLargLayout.isVisible = true
                } else {
                    adapter.itemList = it as ArrayList<NumData>
                    adapter.notifyDataSetChanged()
                    if (it.size > 1) {
                        alist.clear()
                        alist.addAll(it)
                        alist.sortByDescending { it.num }
                        val secondLargeNum = alist.get(1).num
                        notificationsViewModel.update(secondLargeNum)
                        enteredNumRecycler.smoothScrollToPosition(it.size - 1)
                    }
                }
            }
        }


        notificationsViewModel.secLargNum.observe(viewLifecycleOwner) {
            it.let {
                secLargeNumtv.text = "" + it
            }
        }


    }

    private fun processEnteredNumber() {
        if (editext.text.isEmpty()) {
            Toast.makeText(context, "Enter number", Toast.LENGTH_SHORT).show()
        } else {
            try {
                notificationsViewModel.add(editext.text.toString().toInt())
                editext.text.clear()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Error occurred, number not valid!", Toast.LENGTH_SHORT)
                    .show()
                editext.text.clear()
            }

        }
    }

}