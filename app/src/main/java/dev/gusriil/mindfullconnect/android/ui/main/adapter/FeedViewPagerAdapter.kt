package dev.gusriil.mindfullconnect.android.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.gusriil.mindfullconnect.android.ui.main.fragment.post.FavoritesPostFragment
import dev.gusriil.mindfullconnect.android.ui.main.fragment.post.FeedPostFragment
import dev.gusriil.mindfullconnect.android.ui.main.fragment.post.MyPostFragment
import dev.gusriil.mindfullconnect.android.ui.main.fragment.post.PopularPostFragment


private const val NUM_TABS = 4

class FeedViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FeedPostFragment()
            1 -> return MyPostFragment()
            2 -> return PopularPostFragment()
            3 -> return FavoritesPostFragment()
        }
        return FeedPostFragment()
    }
}