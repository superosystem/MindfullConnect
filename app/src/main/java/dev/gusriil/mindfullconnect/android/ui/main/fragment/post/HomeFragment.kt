package dev.gusriil.mindfullconnect.android.ui.main.fragment.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import dev.gusriil.mindfullconnect.android.R
import dev.gusriil.mindfullconnect.android.databinding.FragmentHomeBinding
import dev.gusriil.mindfullconnect.android.ui.main.BaseFragmentWithBinding
import dev.gusriil.mindfullconnect.android.ui.main.adapter.FeedViewPagerAdapter

class HomeFragment : BaseFragmentWithBinding<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val feedTabArrays = arrayOf(
            getString(R.string.tab_name_recent),
            getString(R.string.tab_name_my),
            getString(R.string.tab_name_popular),
            getString(R.string.tab_name_favorites)
        )
        val adapterView = FeedViewPagerAdapter(childFragmentManager, lifecycle)
        val viewPager = binding.pager
        val tabLayout = binding.tabLayout
        viewPager.adapter = adapterView
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = feedTabArrays[position]
        }.attach()
    }

}