package com.chan.mytabling

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.chan.mytabling.databinding.ActivityMainBinding
import com.chan.recent.ui.RecentFragmentDirections
import com.chan.save.ui.SaveFragmentDirections
import com.chan.ui.BaseActivity
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_main
        ) as NavHostFragment).navController
    }

    private val tabSelectedListener: TabLayout.OnTabSelectedListener by lazy {
        object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.text) {
                    getString(R.string.title_save) ->
                        navController.navigate(
                            RecentFragmentDirections.actionRecentFragmentToSaveFragmentGraph()
                        )
                    getString(R.string.title_recent) ->
                        navController.navigate(
                            SaveFragmentDirections.actionSaveFragmentToRecentFragmentGraph()
                        )
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
        navListener(navController)
    }

    private fun navListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Timber.d("destination >>>>>>>> ${destination.label}")
            destination.label?.let {
                binding.tabLayout.removeOnTabSelectedListener(tabSelectedListener)
                if (it == getString(R.string.title_save)) {
                    binding.tabLayout.getTabAt(TAB_SAVE_POSITION)?.select()
                } else {
                    binding.tabLayout.getTabAt(TAB_RECENT_POSITION)?.select()
                }
                binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
            }
        }
    }

    companion object {
        private const val TAB_SAVE_POSITION = 0
        private const val TAB_RECENT_POSITION = 1
    }
}