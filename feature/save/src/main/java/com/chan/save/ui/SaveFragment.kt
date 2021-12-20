package com.chan.save.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import com.chan.save.R
import com.chan.save.databinding.FragmentSaveBinding
import com.chan.save.domain.Product
import com.chan.ui.BR
import com.chan.ui.BaseFragment
import com.chan.ui.adapter.BaseListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : BaseFragment<FragmentSaveBinding>(
    FragmentSaveBinding::inflate
) {
    private val viewModel by activityViewModels<SaveProductViewModel>()
    private val listAdapter: BaseListAdapter<Product> by lazy {
        BaseListAdapter(
            layoutResourceId = R.layout.rv_save_item,
            viewHolderBindingId = BR.product,
            viewModel = mapOf(BR.viewModel to viewModel),
            object : DiffUtil.ItemCallback<Product>() {
                override fun areItemsTheSame(
                    oldItem: Product,
                    newItem: Product
                ): Boolean =
                    oldItem.restaurantIdx == newItem.restaurantIdx

                override fun areContentsTheSame(
                    oldItem: Product, newItem: Product
                ): Boolean = oldItem == newItem
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecyclerView()
        initViewModelObserve()
        initData()
    }

    private fun initViewModel() {
        binding.viewModel = viewModel
    }

    private fun initRecyclerView() {
        binding.rvContent.adapter = listAdapter
    }

    private fun initViewModelObserve() {
        viewModel.products.observe(viewLifecycleOwner, {
            listAdapter.submitList(it)
        })
    }

    private fun initData(){
        viewModel.fetchProduct()
    }
}