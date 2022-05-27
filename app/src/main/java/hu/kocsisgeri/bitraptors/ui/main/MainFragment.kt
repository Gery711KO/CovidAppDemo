package hu.kocsisgeri.bitraptors.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.databinding.FragmentMainBinding
import hu.kocsisgeri.bitraptors.ui.adapter.DiffListAdapter
import hu.kocsisgeri.bitraptors.ui.adapter.NotifyingLinearLayoutManager
import hu.kocsisgeri.bitraptors.ui.adapter.cell.cellPersonDelegate
import hu.kocsisgeri.bitraptors.ui.decoration.ItemOffsetDecoration
import hu.kocsisgeri.bitraptors.ui.filter.FilterFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.Bidi

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModel()
    private val listAdapter = DiffListAdapter(cellPersonDelegate { viewModel.selected.tryEmit(it) })
    private val decoration = ItemOffsetDecoration()
    private val filter = FilterFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()
        setupOther()
        setupSwipeToRefresh()
        setupCovidsObserver()
        setupVaccinatedObserver()
        setupMaxIdObserver()
        setupFilterObserver()
    }

    private fun setupCovidsObserver() {
        viewModel.covids.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    listAdapter.updateData(it.data)
                    binding.caseCount.text = it.data.size.toString()
                    binding.downloadingLayout.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    binding.viewRC.visibility = View.VISIBLE
                    binding.caseCount.visibility = View.VISIBLE
                    binding.caseCount.text = it.data.size.toString()
                    if (!binding.viewRC.isComputingLayout) {
                        binding.motionLayout.transitionToStart()
                    }
                }
                is ApiResult.Progress -> {
                    binding.viewRC.visibility = View.GONE
                    binding.caseCount.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                    binding.progressBar.progress = it.percentage
                }
                is ApiResult.Error -> {
                    binding.downloadingLayout.visibility = View.GONE
                    binding.internetConnectionText.visibility = View.VISIBLE
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    private fun setupList() {
        binding.viewRC.apply {
            layoutManager = NotifyingLinearLayoutManager(context)
            adapter = listAdapter
            addItemDecoration(decoration)
        }
        (binding.viewRC.layoutManager as NotifyingLinearLayoutManager).mCallback = object : NotifyingLinearLayoutManager.OnLayoutCompleteCallback {
            override fun onLayoutComplete() {
                binding.motionLayout.transitionToStart()
                binding.viewRC.scrollToPosition(0)
            }
        }
    }

    private fun setupFilterObserver() {
        viewModel.filtering.observe(viewLifecycleOwner) {
            binding.motionLayout.transitionToEnd()
        }
    }

    private fun setupOther() {
        binding.fab.setOnClickListener {
            if (childFragmentManager.fragments.size == 0) {
                filter.show(childFragmentManager, FilterFragment.TAG)
            }
        }

        binding.scrollToTop.setOnClickListener {
            binding.viewRC.scrollToPosition(0)
        }
    }

    private fun setupVaccinatedObserver() {
        viewModel.vaccinated.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResult.Success -> {
                    binding.vaccinatedText.text = it.data
                    binding.progressCircle.visibility = View.GONE
                    binding.internetConnectionText.visibility = View.GONE
                    binding.vaccinatedLayout.visibility = View.VISIBLE
                    binding.swipeToRefresh.isRefreshing = false
                }
                is ApiResult.Error -> {
                    binding.internetConnectionText.visibility = View.VISIBLE
                    binding.progressCircle.visibility = View.GONE
                    binding.vaccinatedLayout.visibility = View.GONE
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    private fun setupMaxIdObserver() {
        viewModel.maxId.observe(viewLifecycleOwner) {

            when (it) {
                is ApiResult.Success -> {
                    binding.deadText.text = it.data
                    binding.progressCircle.visibility = View.GONE
                    binding.internetConnectionText.visibility = View.GONE
                    binding.deadLayout.visibility = View.VISIBLE
                    binding.swipeToRefresh.isRefreshing = false
                }
                is ApiResult.Error -> {
                    binding.internetConnectionText.visibility = View.VISIBLE
                    binding.progressCircle.visibility = View.GONE
                    binding.deadLayout.visibility = View.GONE
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    private fun setupSwipeToRefresh() {
        binding.swipeToRefresh.setProgressBackgroundColorSchemeColor(Color.rgb(14, 14, 14))
        binding.swipeToRefresh.setColorSchemeColors(Color.rgb(218, 218, 218))
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.refreshFunc()
        }
    }

    override fun onResume() {
        super.onResume()

        if (binding.progressBar.progress == binding.progressBar.max || binding.progressBar.progress == 0) {
            viewModel.refreshFunc()
        }
    }
}