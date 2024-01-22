package com.alieser.libraryproject.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager : FragmentManager, lifecycle : Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount(): Int {

        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0 -> FeaturesFragment()
            1 -> RatingFragment()
            2 -> QuestionsFragment()
            else -> {Fragment()}
        }

    }
}