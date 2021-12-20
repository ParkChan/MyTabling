package com.chan.mytabling

import android.os.Bundle
import androidx.navigation.findNavController
import com.chan.mytabling.databinding.ActivityMainBinding
import com.chan.ui.BaseActivity
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val tabLayout = binding.tabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Timber.d("tab >>>>>> ${tab.text}")
                when (tab.text) {
                    getString(R.string.title_save) ->
                        navController.navigate(R.id.action_recent_fragment_to_save_fragment_graph)
                    getString(R.string.title_recent) ->
                        navController.navigate(R.id.action_save_fragment_to_recent_fragment_graph)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}