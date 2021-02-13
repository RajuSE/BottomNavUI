package devx.raju.bottomnav.ui.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import devx.raju.bottomnav.ui.main.dashboard.adapter.SecondRecyclerViewAdapter
import devx.raju.bottomnav.R
import devx.raju.bottomnav.common.uiutils.DummyUtils
import devx.raju.bottomnav.common.uiutils.setLayAnimation
import devx.raju.bottomnav.ui.main.ItemData
import devx.raju.bottomnav.ui.main.dashboard.adapter.DashbHorizontalAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstRecyclerView.setLayAnimation()
        secondRecyclerView.setLayAnimation()
        firstRecyclerView.adapter =
            DashbHorizontalAdapter(requireContext(), DummyUtils.getDashbDummy())
        secondRecyclerView.adapter =
            SecondRecyclerViewAdapter(requireContext(), DummyUtils.getDashbVerticalDummy())
    }
}