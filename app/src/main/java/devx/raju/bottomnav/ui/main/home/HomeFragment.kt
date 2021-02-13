package devx.raju.bottomnav.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import devx.raju.bottomnav.R
import devx.raju.bottomnav.common.uiutils.DummyUtils
import devx.raju.bottomnav.common.uiutils.setLayAnimation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hipHopRecycler.setLayAnimation()
        popRecycler.setLayAnimation()
        rnbRecycler.setLayAnimation()
        hipHopRecycler.adapter = HomeHorizontalAdapter(requireContext(), DummyUtils.getDashbDummy())
        popRecycler.adapter = HomeHorizontalAdapter(requireContext(), DummyUtils.getDashbDummy())
        rnbRecycler.adapter = HomeHorizontalAdapter(requireContext(), DummyUtils.getDashbDummy())
    }
}